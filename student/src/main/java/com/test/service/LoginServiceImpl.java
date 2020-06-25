package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.LoginDAO;
import com.test.vo.DepartmentVO;
import com.test.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO dao;
	
	@Override
	public List<DepartmentVO> getDepartment() {
		// TODO Auto-generated method stub
		return dao.getDepartment();
	}

	@Override
	public void join(LoginVO vo) {
		dao.join(vo);
	}

	@Override
	public LoginVO login(LoginVO vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	@Override
	public void memberDrop(int m_no) {
		dao.memberDrop(m_no);
	}
	
	@Override
	public int idChk(String id) {
		// TODO Auto-generated method stub
		return dao.idChk(id);
	}
	
	@Override
	public int emailChk(String email) {
		// TODO Auto-generated method stub
		return dao.emailChk(email);
	}

	@Override
	public String getPw(int m_no) {
		// TODO Auto-generated method stub
		return dao.getPw(m_no);
	}

	@Override
	public void changePw(LoginVO vo) {
		dao.changePw(vo);
	}

	@Override
	public String getId(String email) {
		// TODO Auto-generated method stub
		return dao.getId(email);
	}
}
