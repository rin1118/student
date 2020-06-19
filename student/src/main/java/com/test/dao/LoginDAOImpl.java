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
		return sqlSession.selectList("loginMapper.getDepartment");
	}

	@Override
	public void join(LoginVO vo) {
		sqlSession.insert("loginMapper.join", vo);
	}

	@Override
	public LoginVO login(LoginVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("loginMapper.login", vo);
	}

}
