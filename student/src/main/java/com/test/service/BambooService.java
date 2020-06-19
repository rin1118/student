package com.test.service;

import java.util.List;

import com.test.vo.BambooVO;

public interface BambooService {
	public void write(BambooVO vo);
	public List<BambooVO> getList();
	public void favIncrement(BambooVO vo);
	public void notFavIncrement(BambooVO vo);
	public List<BambooVO> search(BambooVO vo);
}
