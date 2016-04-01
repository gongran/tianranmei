package com.tianranmei.dao;

import java.util.List;

import com.tianranmei.po.Member;

public interface MemberDao {
	public List<Member> getAll();
	
	public void insert(Member member);
	public void delete(Member member); 
	public void update(Member member);
	public List<Member> getMemberByCond(Member member);

}
