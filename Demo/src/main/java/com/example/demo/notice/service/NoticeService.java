package com.example.demo.notice.service;

import java.util.List;

public interface NoticeService {

	public List<Notice> getNoticeList()throws Exception;
	
	public Notice getNotice(String bo_seq_no)throws Exception;
	
	public int insertNotice(Notice notice)throws Exception;
}
