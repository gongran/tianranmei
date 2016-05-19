package com.tianranmei.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

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
		Criteria criteria = getSession().createCriteria(Member.class);
//		if (member.getId() != null) {//id不能直接作为条件 目前不清楚为什么
//			criteria.add(Restrictions.eq("id", member.getId()));
//		}
		List<Member> result = criteria.add(Example.create(member)).list();
		return result;
	}

}
