package com.example.demo.member.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.member.service.Member;

@Mapper
public interface MemberMapper {
	
	public int selectTotalCount(Map<String,Object> param)throws Exception;
	
	public List<Member> selectMemberList(Map<String,Object> param)throws Exception;
	
	public Member selectMember(String mem_id)throws Exception;
	
	public int insertMember(Member member)throws Exception;
	
	public int updateMember(Member member)throws Exception;
	
	public int deleteMember(String mem_id)throws Exception;
	
	
}
