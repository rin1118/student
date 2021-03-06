package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.vo.DepartmentVO;
import com.test.vo.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<DepartmentVO> getDepartment() {
		return sqlSession.selectList("homeMapper.getDepartment");
	}

	@Override
	public void join(LoginVO vo) {
		sqlSession.insert("homeMapper.join", vo);
	}

	@Override
	public LoginVO login(LoginVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("homeMapper.login", vo);
	}

	@Override
	public void memberDrop(int m_no) {
		sqlSession.delete("homeMapper.memberDrop", m_no);
	}
	
	@Override
	public int idChk(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("homeMapper.idChk", id);
	}
	
	@Override
	public int emailChk(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("homeMapper.emailChk", email);
	}

	@Override
	public String getPw(int m_no) {
		return sqlSession.selectOne("homeMapper.getPw", m_no);
	}

	@Override
	public void changePw(LoginVO vo) {
		sqlSession.update("homeMapper.pwUpdate", vo);
	}

	@Override
	public String getId(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("homeMapper.getId", email);
	}

	@Override
	public int getM_no(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("homeMapper.getM_no", email);
	}


}
