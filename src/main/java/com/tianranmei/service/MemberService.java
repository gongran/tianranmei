package com.tianranmei.service;

import java.util.List;

import com.tianranmei.po.Member;

public interface MemberService {
	public List<Member> findAll();
	
	public List<Member> findMemberByCond(Member member);
	public void add(Member member);
	public void delete(Member member);
	public void update(Member member);

}
