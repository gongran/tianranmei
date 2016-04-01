package com.tianranmei.service.impl;

import java.util.List;

import com.tianranmei.dao.MemberDao;
import com.tianranmei.po.Member;
import com.tianranmei.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public List<Member> findAll() {
		return memberDao.getAll();
	}

	@Override
	public List<Member> findMemberByCond(Member member) {
		return memberDao.getMemberByCond(member);
	}

	@Override
	public void add(Member member) {
		memberDao.insert(member);		
	}

	@Override
	public void delete(Member member) {
		memberDao.delete(member);
		
	}
	@Override
	public void update(Member member) {
		memberDao.update(member);
	}

}
