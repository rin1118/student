package com.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int write(BoardVO boardVO) throws Exception {
		int insertCount = sqlSession.insert("boardMapper.insert", boardVO);
		return insertCount;
	}

	@Override
	public List<BoardVO> getList() throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("boardMapper.getList");
	}

	@Override
	public BoardVO selectOne(int b_no) throws Exception {
		
		return sqlSession.selectOne("boardMapper.selectOne", b_no);
	}

	@Override
	public void update(BoardVO boardVO) {
		sqlSession.update("boardMapper.update", boardVO);			
	}

	@Override
	public void delete(int b_no) throws Exception {
		sqlSession.update("boardMapper.delete", b_no);			
	}

}
