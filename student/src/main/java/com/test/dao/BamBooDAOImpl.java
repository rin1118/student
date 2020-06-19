package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.vo.BambooVO;

@Repository
public class BamBooDAOImpl implements BambooDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(BambooVO vo) {
		sqlSession.insert("bambooMapper.insert", vo);
	}

	@Override
	public List<BambooVO> getList() {
		return sqlSession.selectList("bambooMapper.getList");
	}

	@Override
	public void favIncrement(BambooVO vo) {
		sqlSession.insert("bambooMapper.favUpdate", vo);
	}

	@Override
	public void notFavIncrement(BambooVO vo) {
		sqlSession.insert("bambooMapper.notFavUpdate", vo);
	}

	@Override
	public List<BambooVO> search(BambooVO vo) {
		// TODO Auto-generated method stub
		System.out.println("서비스구현"+vo.getCategory());
		
		return sqlSession.selectList("bambooMapper.search", vo);
	}

}
