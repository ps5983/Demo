package com.example.demo.member.service;

import java.util.List;
import java.util.Map;

public interface MemberService {
	
	public int getTotalCount(Map<String, Object> param)throws Exception;
	
	public List<Member> getMemberList(Map<String, Object> param)throws Exception;//매퍼는 db쿼리와 밀접한 관련있는데 service는 비지니스로직에 관련되어있어서 의미잇는 네이밍으로 지음
	
	public Member getMember(String mem_id)throws Exception;
	
	public int insertMember(Member member)throws Exception;
	
	public int updateMember(Member member)throws Exception;
	
	public int deleteMember(String mem_id)throws Exception;

}
