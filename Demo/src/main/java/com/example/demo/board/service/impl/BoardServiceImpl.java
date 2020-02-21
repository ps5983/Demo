package com.example.demo.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.service.Board;
import com.example.demo.board.service.BoardService;

@Service("boardService")//해도되고 안해도되는데 resource라는 어노테이션을 쓸 때 필요해서 그냥 일단 넣어놈
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int getTotalCount(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectTotalCount(param);
	}

	@Override
	public List<Board> getBoardList(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardList(param);
	}

	@Override
	public Board getBoard(int bo_seq_no,boolean isUpdCnt) throws Exception {
		
		if(isUpdCnt) {
		boardMapper.updateHitCnt(bo_seq_no);// 조회수 올라가는거
		}
		return boardMapper.selectBoard(bo_seq_no);
		}

	@Override
	public int insertBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.insertBoard(board);
	}

	@Override
	public int updateBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(int bo_seq_no) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.deleteBoard(bo_seq_no);
	}

}
