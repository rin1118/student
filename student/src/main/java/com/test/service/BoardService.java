package com.test.service;

import java.util.List;

import com.test.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList() throws Exception;
	public int write(BoardVO boardVO) throws Exception;
	public BoardVO selectOne(int b_no) throws Exception;
	public void update(BoardVO boardVO) throws Exception;
	public void delete(int b_no) throws Exception;
}
