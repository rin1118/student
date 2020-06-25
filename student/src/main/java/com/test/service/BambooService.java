package com.test.service;

import java.util.List;

import com.test.vo.BambooVO;

public interface BambooService {
	public void write(BambooVO vo);
	public List<BambooVO> getList();
	public void favIncrement(BambooVO vo);
	public void notFavIncrement(BambooVO vo);
	public List<BambooVO> search(BambooVO vo);

	//대나무 숲 해당 작성자의 글 가져오기
	public BambooVO writeMessage(BambooVO vo);
	public void messageUpdate(BambooVO vo);
	public void messageDel(int b_no);
}
