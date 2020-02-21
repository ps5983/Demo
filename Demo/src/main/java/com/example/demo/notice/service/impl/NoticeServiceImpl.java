package com.example.demo.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.notice.service.Notice;
import com.example.demo.notice.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> getNoticeList() throws Exception {

		return noticeMapper.selectNoticeList();
	}

	@Override
	public Notice getNotice(String bo_seq_no) throws Exception {
 
		return noticeMapper.selectNotice(bo_seq_no);
	}

	@Override
	public int insertNotice(Notice notice) throws Exception {
		
		return noticeMapper.insertNotice(notice);
	}
}
