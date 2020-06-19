package com.test.dao;

import java.util.List;

import com.test.vo.BambooVO;

public interface BambooDAO {
	public void write(BambooVO vo);
	public List<BambooVO> getList();
	public void favIncrement(BambooVO vo);
	public void notFavIncrement(BambooVO vo);
	public List<BambooVO> search(BambooVO vo);
}
