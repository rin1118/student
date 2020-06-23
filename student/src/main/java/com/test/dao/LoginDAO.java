package com.test.dao;

import java.util.List;

import com.test.vo.DepartmentVO;
import com.test.vo.LoginVO;

public interface LoginDAO {
	//학과명 select
	public List<DepartmentVO> getDepartment();

	//회원가입
	public void join(LoginVO vo);
	public void memberDrop(int m_no);
	
	//로그인
	public LoginVO login(LoginVO vo);
}
