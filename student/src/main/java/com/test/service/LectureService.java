package com.test.service;

import java.util.List;

import com.test.vo.EvaluateVO;
import com.test.vo.GradeVO;
import com.test.vo.LectureBookVO;
import com.test.vo.LectureVO;
import com.test.vo.SearchVO;

public interface LectureService {
	
	//강의등록 (교수)
	public int register(LectureVO lectureVO);
	public List<LectureVO> getList(); 
	public List<LectureVO> registerList(int p_no);	//로그인 구현 후에는 인자로 로그인 한 유저의 교수번호를 던져줄거임
	public LectureVO selectOne(int l_no);
	public void update(LectureVO lectureVO);
	public void delete(int l_no);

	//수강신청 (학생)
	public void lectureSignUp(LectureBookVO bookVO); // 로그인 구현 후 로그인 한 유저의 학번(s_no)을 넣어줘야함
	public List<LectureVO> lectureSignUpList(int s_no);
	public void signUpCancel(int l_no);
	
	//강의평가 (학생)
	public List<EvaluateVO> evaluateList();
	public EvaluateVO evaluateOne(int e_no);
	public List<EvaluateVO> search(SearchVO vo);
	public void evaluateWrite(EvaluateVO vo);
	public void evaluateDelete(int e_no);
	public void evaluateUpdate(EvaluateVO vo);
	
	//성적관리
	public List<GradeVO> gradeChk(int m_no);	//성적 확인
	public List<GradeVO> studentList(int l_no);   //해당 강의를 수강중인 학생 목록 불러오기
	public void gradeUpdate(GradeVO vo);			//성적 업데이트
}
