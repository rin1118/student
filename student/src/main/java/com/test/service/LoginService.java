package com.test.service;

import java.util.List;

import com.test.vo.DepartmentVO;
import com.test.vo.LoginVO;

public interface LoginService {
	//학과명 select
	public List<DepartmentVO> getDepartment();
	
	//회원가입
	public void join(LoginVO vo);
	public void memberDrop(int m_no);
	public int idChk(String id);
	public int emailChk(String email);
	
	//로그인
	public LoginVO login(LoginVO vo);
	
	//비밀번호 변경 (db에서 비밀번호 받아오기)
	public String getPw(int m_no);
	// 비밀번호 변경 처리
	public void changePw(LoginVO vo);
	
	//아이디 찾기
	public String getId(String email);
	
	//비밀번호 찾기 (임시 비밀번호 발급)
	public int getM_no(String email); //해당 이메일을 가진 유저번호 얻어오기
	
}
