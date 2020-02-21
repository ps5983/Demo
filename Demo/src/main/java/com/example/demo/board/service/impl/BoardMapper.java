package com.example.demo.board.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.Board;

@Mapper
public interface BoardMapper {

	public int selectTotalCount(Map<String, Object> param)throws Exception;
	
	public List<Board> selectBoardList(Map<String, Object> param)throws Exception;
	
	public Board selectBoard(int bo_seq_no)throws Exception;
	
	public int insertBoard(Board board)throws Exception;
	
	public int updateBoard(Board board)throws Exception;

	public int deleteBoard(int bo_seq_no)throws Exception;
	
	public int updateHitCnt(int bo_seq_noboard)throws Exception;
}
