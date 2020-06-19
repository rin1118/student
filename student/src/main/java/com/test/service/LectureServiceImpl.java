package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.LectureDAO;
import com.test.vo.EvaluateVO;
import com.test.vo.LectureBookVO;
import com.test.vo.LectureVO;
import com.test.vo.SearchVO;

@Service
public class LectureServiceImpl implements LectureService{
	
	@Autowired
	private LectureDAO dao;

	//강의 등록 (교수)
	@Override
	public int register(LectureVO lectureVO) {
		
		return dao.register(lectureVO);
	}

	@Override
	public List<LectureVO> getList() {
		
		return dao.getList();
	}

	@Override
	public LectureVO selectOne(int l_no) {
		return dao.selectOne(l_no);
	}

	@Override
	public void update(LectureVO lectureVO) {
		dao.update(lectureVO);
	}

	@Override
	public void delete(int l_no) {
		dao.delete(l_no);
	}

	//수강신청 (학생)
	@Override
	public void lectureSignUp(LectureBookVO bookVO) {
		dao.lectureSignUp(bookVO);
	}

	@Override
	public List<LectureVO> lectureSignUpList(int s_no) {
		// TODO Auto-generated method stub
		return dao.lectureSignUpList(s_no);
	}

	@Override
	public void signUpCancel(int l_no) {
		dao.signUpCancel(l_no);
	}

	@Override
	public void evaluateWrite(EvaluateVO vo) {
		// TODO Auto-generated method stub
		dao.evaluateWrite(vo);
	}

	@Override
	public List<EvaluateVO> evaluateList() {
		// TODO Auto-generated method stub
		return dao.evaluateList();
	}

	@Override
	public void evaluateDelete(int e_no) {
		dao.evaluateDelete(e_no);
	}

	@Override
	public EvaluateVO evaluateOne(int e_no) {
		// TODO Auto-generated method stub
		return dao.evaluateOne(e_no);
	}

	@Override
	public void evaluateUpdate(EvaluateVO vo) {
		dao.evaluateUpdate(vo);
	}

	@Override
	public List<EvaluateVO> search(SearchVO vo) {
		// TODO Auto-generated method stub
		return dao.search(vo);
	}

}
