package com.example.demo.notice.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.notice.service.Notice;

@Mapper
public interface NoticeMapper {

	
	public List<Notice> selectNoticeList()throws Exception;
	
	public Notice selectNotice(String bo_seq_no)throws Exception;
	
	public int insertNotice(Notice notice)throws Exception;
	
}
