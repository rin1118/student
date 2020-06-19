package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.BoardDAO;
import com.test.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int write(BoardVO boardVO) throws Exception {
		int insertCount = dao.write(boardVO);
		return insertCount;
	}

	@Override
	public List<BoardVO> getList() throws Exception {
		// TODO Auto-generated method stub
		
		return dao.getList();
	}

	@Override
	public BoardVO selectOne(int b_no) throws Exception {
		return dao.selectOne(b_no);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {

		dao.update(boardVO);

	}

	@Override
	public void delete(int b_no) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(b_no);
	}

}
