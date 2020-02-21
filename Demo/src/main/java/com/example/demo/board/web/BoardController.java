package com.example.demo.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.service.Board;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.util.PagingUtil;
import com.example.demo.member.service.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/boardList")
	public String boardList(Model model
			,String searchType
			,String searchWord
			,@RequestParam(name = "currentPage", defaultValue = "1")int currentPage
			,@RequestParam(name = "pageSize", defaultValue = "20")int pageSize
			) throws Exception {	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("searchType",searchType);
		param.put("searchWord",searchWord);
		
		int totalCount = boardService.getTotalCount(param);
		PagingUtil pagingUtil = new PagingUtil(currentPage, totalCount, pageSize, 5); 
		
		param.put("startRow",pagingUtil.getStartRow());
		param.put("endRow",pagingUtil.getEndRow());
		
		List<Board> boardList = boardService.getBoardList(param);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingUtil", pagingUtil);
		
		return "board/boardList";
	}

	@RequestMapping("/boardView/{bo_seq_no}") // 주소?다음 파라미터 방식이 아닌 다른 방식임 pathvariable..을 사용해서 주소/seq넘버로 되는방식 네이버 카페글들이
												// 그런식
	public String boardView(@PathVariable("board.bo_seq_no") int bo_seq_no, Model model, int bo_hit_cnt) throws Exception {

		Board board = boardService.getBoard(bo_seq_no,true);
		model.addAttribute("board", board);
		return "board/boardView";
	}

	@RequestMapping("/boardForm")
	public String boarForm(HttpSession session) throws Exception {

		Member member = (Member) session.getAttribute("LOGIN_USER");

		if (member == null) {// 세션에 로그인정보가 안담겼을경우 로그인창으로 보냄
			return "redirect:/loginForm";
		}

		return "board/boardForm";
	}

	@RequestMapping("/boardInsert")
	public String boardInsert(Board board, HttpSession session, Model model) throws Exception {
//		board.setBo_type("일반게시판");//jsp에서 해도되고 controller에서 해도되고 jsp에서 하면 hidden으로 파라미터 보내서 사용
		Member member = (Member) session.getAttribute("LOGIN_USER");

		if (member == null) {// 세션에 로그인정보가 안담겼을경우 로그인창으로 보냄
			return "redirect:/loginForm";
		}
		board.setBo_writer(member.getMem_id());
		board.setReg_user(member.getMem_id());
		boolean isError = false;
		String message = "";

		try {
			int updCnt = boardService.insertBoard(board);
			if (updCnt == 0) {
				isError = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}

		if (isError) {// 모델을 사용한 이유는 isError랑 message 받아서 메세지jsp에 보내기 위해서 모델에 담아서 보내ㅐ기 위해 모델 사용
			// 정상등록되었다고 띄워줄때는 모델.add..밑에 로케이션을 하나 추가해줘서 메세지 띄우고 로케이션으로 이동하도록 만들어야함
			message = "등록실패";

			model.addAttribute("isError", isError);
			model.addAttribute("message", message);
			return "common/message";
		}

		return "redirect:board/boardList";
	}

	@RequestMapping("/boardEdit")
	public String boardEdit(@RequestParam("bo_seq_no") int bo_seq_no// 파람 반드시 들어와야함
			, Model model,HttpSession session) throws Exception {

		Board board = boardService.getBoard(bo_seq_no,false);
		model.addAttribute("board", board);
		
		Member member = (Member) session.getAttribute("LOGIN_USER");

		if (member == null) {// 세션에 로그인정보가 안담겼을경우 로그인창으로 보냄
			return "redirect:/loginForm";
		}
		
		return "board/boardEdit";
	}
	
	@RequestMapping("/boardUpdate")
	public String boardUpdate(
			Board board, HttpSession session
			)throws Exception{
		
		Member member = (Member) session.getAttribute("LOGIN_USER");
		if (member == null) {// 세션에 로그인정보가 안담겼을경우 로그인창으로 보냄
			return "redirect:/loginForm";
		}
		board.setUpd_user(member.getMem_id());
		boardService.updateBoard(board);
		return "redirect:/board/boardView" + board.getBo_seq_no();
	}

	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("bo_seq_no") int bo_seq_no,HttpSession session,Model model) throws Exception {

		
		Member member = (Member) session.getAttribute("LOGIN_USER");

		if (member == null) {// 세션에 로그인정보가 안담겼을경우 로그인창으로 보냄
			return "redirect:/loginForm";
		}
		
		boolean isError = false;
		String message = "";
		
		try {
		int updCnt = boardService.deleteBoard(bo_seq_no);
		if(updCnt==0) {
			isError = true;
		}
		}catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		
		if(isError) {
			message = "삭제 실패";
			model.addAttribute("isError",isError);
			model.addAttribute("message",message);
			return "common/message";
		}
		return "redirect:board/boardList";
	}
}
