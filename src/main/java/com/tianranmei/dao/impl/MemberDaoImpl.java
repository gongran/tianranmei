package com.tianranmei.dao.impl;

import java.util.List;

import org.hibernate.criterion.Example;

import com.tianranmei.dao.MemberDao;
import com.tianranmei.po.Member;

public class MemberDaoImpl extends BaseDao implements MemberDao {

	@Override
	public List<Member> getAll() {
		String hql = "from Member";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void insert(Member member) {
        getSession().save(member);		
	}

	@Override
	public void delete(Member member) {
		getSession().delete(member);
	}

	@Override
	public void update(Member member) {
		getSession().saveOrUpdate(member);
	}

	@Override
	public List<Member> getMemberByCond(Member member) {
		List<Member> result=getSession().createCriteria(Member.class).add(Example.create(member)).list();
		return result;
	}

}
