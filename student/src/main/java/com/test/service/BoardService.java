package com.test.service;

import java.util.List;

import com.test.vo.BoardVO;
import com.test.vo.Criteria;

public interface BoardService {
	
	//게시물 총 갯수 얻기
	public int listCount();
		
	//게시물 목록 조회 (페이징 적용)
	public List<BoardVO> list(Criteria cri);
	
	public List<BoardVO> getList() throws Exception;
	public int write(BoardVO boardVO) throws Exception;
	public BoardVO selectOne(int b_no) throws Exception;
	public void update(BoardVO boardVO) throws Exception;
	public void delete(int b_no) throws Exception;
}

