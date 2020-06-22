package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.vo.EvaluateVO;
import com.test.vo.GradeVO;
import com.test.vo.LectureBookVO;
import com.test.vo.LectureVO;
import com.test.vo.SearchVO;

@Repository
public class LectureDAOImpl implements LectureDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int register(LectureVO lectureVO) {
		return sqlSession.insert("lectureMapper.insert", lectureVO);
	}

	@Override
	public List<LectureVO> getList() {
		return sqlSession.selectList("lectureMapper.getList");
	}
	
	@Override
	public List<LectureVO> registerList(int p_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("lectureMapper.registerList", p_no);
	}
	
	@Override
	public LectureVO selectOne(int l_no) {
		return sqlSession.selectOne("lectureMapper.selectOne", l_no);
	}

	@Override
	public void update(LectureVO lectureVO) {
		sqlSession.update("lectureMapper.update", lectureVO);
	}

	@Override
	public void delete(int l_no) {
		sqlSession.delete("lectureMapper.delete", l_no);
	}

	@Override
	public void lectureSignUp(LectureBookVO bookVO) {
		sqlSession.insert("lectureMapper.lectureSignUp", bookVO);
	}

	@Override
	public List<LectureVO> lectureSignUpList(int s_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("lectureMapper.lectureSignUpList", s_no);
	}

	@Override
	public void signUpCancel(int l_no) {
		sqlSession.delete("lectureMapper.signUpCancel", l_no);
	}

	@Override
	public void evaluateWrite(EvaluateVO vo) {
		sqlSession.insert("lectureMapper.evaluateWrite", vo);
	}

	@Override
	public List<EvaluateVO> evaluateList() {
		return sqlSession.selectList("lectureMapper.evaluateList");
	}

	@Override
	public void evaluateDelete(int e_no) {
		sqlSession.delete("lectureMapper.evaluateDelete", e_no);
	}

	@Override
	public EvaluateVO evaluateOne(int e_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("lectureMapper.evaluateOne", e_no);
	}

	@Override
	public void evaluateUpdate(EvaluateVO vo) {
		sqlSession.update("lectureMapper.evaluateUpdate", vo);
	}

	@Override
	public List<EvaluateVO> search(SearchVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("lectureMapper.search", vo);
	}

	@Override
	public List<GradeVO> gradeChk(int m_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("lectureMapper.gradeChk", m_no);
	}

	@Override
	public List<GradeVO> studentList(int l_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("lectureMapper.studentList", l_no);
	}

	@Override
	public void gradeUpdate(GradeVO vo) {
		sqlSession.update("lectureMapper.gradeUpdate", vo);
	}



}
