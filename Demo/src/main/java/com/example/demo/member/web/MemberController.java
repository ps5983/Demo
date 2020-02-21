package com.example.demo.member.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.util.PagingUtil;
import com.example.demo.member.service.Member;
import com.example.demo.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired // 리소스나 auto나 둘중 암거나 쓰면됨
	private MemberService memberService;

	@RequestMapping("/memberList")
	public String memberList(Model model,String searchType, String searchWord
			//페이지
			,@RequestParam(name = "currentPage",defaultValue = "1") int currentPage
			) throws Exception {
		Map<String,Object> param = new HashMap<String, Object>();
		
		param.put("searchType", searchType);
		param.put("searchWord", searchWord);
		
		//paging
		int totalCount = memberService.getTotalCount(param);
		int pageSize = 10;
		int pageCount = 5;
		PagingUtil pagingUtil = new PagingUtil(currentPage, totalCount, pageSize, pageCount);
		
		param.put("startRow", pagingUtil.getStartRow());
		param.put("endRow", pagingUtil.getEndRow());
		
		
		List<Member> memberList = memberService.getMemberList(param);
		model.addAttribute("memberList", memberList);
		model.addAttribute("pagingUtil", pagingUtil);
		
		
		
		return "member/memberList";
	}

	// get 만 받을때 겟방식 선언해줌
	@RequestMapping(value = "/memberView", method = RequestMethod.GET) // /memberView의 디펄트값은 value지만 메소드란이 들어갈때 구분해주기위해
	public String memberView(
			// @RequestParam(value = "id", required = true, defaultValue="---") ==> String
			// mem_id 에 파라미터를 id로 받아서 url도 달라지고 required = true는 무조건 써야한다라는뜻
			// 디펄트벨류 값이 안오면 디펄트값을 ---로 설정해라
			String mem_id, Model model) throws Exception {

		Member member = memberService.getMember(mem_id);// 멤버에 아이디받아옴
		model.addAttribute("member", member);// 멤버에 아이디를 받아서 모델에 데이터답아서 화면에 뿌려즘

		return "member/memberView";
	}

	@RequestMapping("/memberForm")
	public String memberForm() throws Exception {

		return "member/memberForm";
	}

	@RequestMapping("/memberInsert")
	public String memberInsert(Member member) throws Exception {

		member.setReg_user(member.getMem_id());

		int updCnt = memberService.insertMember(member);
		if (updCnt > 0) {

		}

		return "redirect:/member/memberList";
	}

	@RequestMapping("/memberEdit")
	public String memberEdit(String mem_id, Model model) throws Exception {
		Member member = memberService.getMember(mem_id);
		model.addAttribute("member", member);

		return "member/memberEdit";
	}

	@RequestMapping("/memberUpdate")
	public String memberUpdate(
			@ModelAttribute(value = "model")Member member
			//,Model model 두번 작업할거 modelattribuew사용해서 한방에 가능
			//모델엔 입력했던 정보가 화면이 새로고침되면 입력했던 정보가 다 날라가기때문에 
			//모델에 입력 정보를 같이 동시에 저장해줌
			) throws Exception {
		member.setUpd_user(member.getMem_id());
		boolean isError = false;
		try {
			int updCnt = memberService.updateMember(member);
			if (updCnt > 0) {
				// 카운트가 0개 이상이면 어디로 보내주거나 그런 로직에 따라 다름
				return "redirect:/member/memberView?mem_id=" + member.getMem_id();

			} else {
				isError = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isError = true;
		}
		
		//model.addAttribute("member", member);
		return "redirect:/member/memberList";
	}

	@RequestMapping("/memberDelete")
	public String memberDelete(String mem_id) throws Exception {

		int upCnt = memberService.deleteMember(mem_id);
		
		return "redirect:/member/memberList";
	}

}
