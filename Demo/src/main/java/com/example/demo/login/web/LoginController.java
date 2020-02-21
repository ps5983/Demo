package com.example.demo.login.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.member.service.Member;
import com.example.demo.member.service.MemberService;

@Controller
//@RequestMapping("/member") 이게 들어가면 url앞에 기본경로로 설정되서 url에 같이 써줘야함 리퀘스트매핑쓰면
public class LoginController {

	@Autowired 	
	private MemberService memberService;

	@RequestMapping("/loginForm")
	public String loginForm() throws Exception {
		return "member/loginForm";
	}

	@RequestMapping("/login")//로그인 정보는 session에 담기기때문에 쉽게 로그아웃도 session만 끊어주면 되는 형태
	public String login(@RequestParam("mem_id") String mem_id, @RequestParam("mem_pwd") String mem_pwd,
			HttpSession session,Model model) throws Exception {

		boolean isError = false;
		String message = "";

		Member member = memberService.getMember(mem_id);
		if (member != null) {// 멤버에 아이디가 담겨서 멤버객체에 데이터들이담겨있을 때 == member가 비어있지 안흥ㄹ때
			if (member.getMem_pwd().equals(mem_pwd)) {
				session.setAttribute("LOGIN_USER", member);

				return "redirect:/";
			} else {
				// 회원 정보가 없을때
				isError = true;
				message = "비밀번호를 찾을 수 없습니다.";
			}

		} else {
			// 회원 정보가 없을때
			isError = true;
			message = "해당 아이디를 찾을 수 없습니다.";

		}
		model.addAttribute("isError",isError);
		model.addAttribute("message",message);
//		model.addAttribute("locationURL","/"); 성공일때 어디로 이동하고 싶을때
		
		return "common/message";
	}

	@RequestMapping("/logout")
	public String logout(
			HttpSession session
			) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
}
