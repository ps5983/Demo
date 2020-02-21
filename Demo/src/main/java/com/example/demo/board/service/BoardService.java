package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	
	
	public int getTotalCount(Map<String, Object> param)throws Exception;
	
	public List<Board> getBoardList(Map<String, Object> param)throws Exception;
	
	public Board getBoard(int bo_seq_no,boolean isUpdCnt)throws Exception;
	
	public int insertBoard(Board board)throws Exception;
	
	public int updateBoard(Board board)throws Exception;

	public int deleteBoard(int bo_seq_no)throws Exception;
	
//	public int updateHitCnt(int bo_seq_noboard)throws Exception; 

}
