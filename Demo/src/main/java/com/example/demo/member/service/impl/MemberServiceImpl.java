package com.example.demo.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.service.Member;
import com.example.demo.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	
	
	
	@Override
	public List<Member> getMemberList(Map<String,Object> param) throws Exception {
		
		return memberMapper.selectMemberList(param);
	}

	@Override
	public Member getMember(String mem_id) throws Exception {
	
		return memberMapper.selectMember(mem_id);
	}

	@Override
	public int insertMember(Member member) throws Exception {

		return memberMapper.insertMember(member);
	}

	@Override
	public int updateMember(Member member) throws Exception {

		return memberMapper.updateMember(member);
	}

	@Override
	public int deleteMember(String mem_id) throws Exception {

		return memberMapper.deleteMember(mem_id);
	}

	@Override
	public int getTotalCount(Map<String, Object> param) throws Exception {
		
		return memberMapper.selectTotalCount(param);
	}

}
