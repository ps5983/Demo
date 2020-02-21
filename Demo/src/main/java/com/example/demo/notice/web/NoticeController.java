package com.example.demo.notice.web;

import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.notice.service.Notice;
import com.example.demo.notice.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
//	Log4JLogger log = new Log4JLogger();
	
	Log4JLogger log = new Log4JLogger();
	@Autowired
	private NoticeService noticeService;
	
//	@Autowired
//	private Member member;
	
	@RequestMapping("/noticeList")
	public String noticeList(Model model)throws Exception{
	
		List<Notice> noticeList = noticeService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
	return "notice/noticeList";
	}
	
	@RequestMapping(value = "/noticeView", method = RequestMethod.GET)
	public String noticeView(String bo_seq_no, Model model)throws Exception{
	
		Notice notice = noticeService.getNotice(bo_seq_no);
		model.addAttribute("notice",notice);
	
		return "notice/noticeView";
	}
	
	@RequestMapping("/noticeForm")
	public String noticeForm() throws Exception{
		return "notice/noticeForm";
	}
	
	@RequestMapping("/noticeInsert")
	public String noticeInsert(String bo_seq_no,Notice notice)throws Exception{
		
//		notice.setBo_writer(member.getMem_id());
		//TOOD 
		
//		noticeService.insertNotice(notice);
		
//		log.debug("notiiceeeeeeeeeeeeeeeeeeeeee-----------"+notice);
		return "redirect:/notice/noticeList";
	}
	
}
