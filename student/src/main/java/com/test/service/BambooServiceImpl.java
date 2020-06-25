package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.BambooDAO;
import com.test.vo.BambooVO;

@Service
public class BambooServiceImpl implements BambooService {

	@Autowired
	BambooDAO dao;
	
	@Override
	public void write(BambooVO vo) {
		dao.write(vo);
	}

	@Override
	public List<BambooVO> getList() {
		return dao.getList();
	}

	@Override
	public void favIncrement(BambooVO vo) {
		dao.favIncrement(vo);
	}

	@Override
	public void notFavIncrement(BambooVO vo) {
		dao.notFavIncrement(vo);
	}

	@Override
	public List<BambooVO> search(BambooVO vo) {
		// TODO Auto-generated method stub
		return dao.search(vo);
	}

	@Override
	public BambooVO writeMessage(BambooVO vo) {
		// TODO Auto-generated method stub
		return dao.writeMessage(vo);
	}

	@Override
	public void messageUpdate(BambooVO vo) {
		dao.messageUpdate(vo);
	}

	@Override
	public void messageDel(int b_no) {
		dao.messageDel(b_no);
	}

}
