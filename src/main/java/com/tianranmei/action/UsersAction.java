package com.tianranmei.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tianranmei.po.Member;
import com.tianranmei.service.MemberService;

public class UsersAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UsersAction.class);

	@Autowired
	private MemberService memberService;
	private Map<String, Object> dataMap;

	private Member member;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public String loginUser() {
		dataMap = new HashMap<String, Object>();
		Member loginMember = new Member();
		if (member != null) {
			loginMember.setKahao(member.getKahao());
			loginMember.setPassword(member.getPassword());
		}
		List<Member> members = memberService.findMemberByCond(loginMember);
		if (members != null && members.size() > 0) {
			dataMap.put("success", true);
			member = members.get(0);
		} else {
			dataMap.put("success", false);
		}
		return SUCCESS;
	}

	/**
	 * 编辑会员信息
	 * 
	 * @return
	 */
	public String editMember() {
		dataMap = new HashMap<String, Object>();
		try {
			memberService.update(member);
			dataMap.put("success", true);
		} catch (Exception e) {
			dataMap.put("success", false);
			log.error(e);
		}
		return SUCCESS;
	}

	/**
	 * 添加或编辑用户信息
	 * 
	 * @return
	 */
	public String addOrUpdateMember() {
		dataMap = new HashMap<String, Object>();
		try {
			Integer id = member.getId();
			if (id == null || id.equals(0)) {
				memberService.add(member);
			} else {
				memberService.update(member);
			}
			dataMap.put("success", true);
		} catch (Exception e) {
			dataMap.put("success", false);
			log.error(e);
		}

		return SUCCESS;
	}

	public String toMember() {
		Integer id=null;
		if(member!=null){
			id=member.getId();
			member=new Member();
			member.setId(id);
//			member.setName("abc");
			List<Member> mems=memberService.findMemberByCond(member);
			member=mems!=null?mems.get(0):null;
		}
		return "member";
	}

	public String findMembers() {
		dataMap = new HashMap<String, Object>();
		try {
			List<Member> members = memberService.findAll();
			dataMap.put("members", members);
			// 放入一个是否操作成功的标识
			dataMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public static Log getLog() {
		return log;
	}

}
