package com.tianranmei.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.tianranmei.po.Member;
import com.tianranmei.service.MemberService;

public class UsersAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UsersAction.class);
	
	private MemberService memberService;
	private Map<String,Object> dataMap; 
	
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

	public String loginUser(){
		dataMap = new HashMap<String, Object>();
		List<Member> members=memberService.findMemberByCond(member);
		if(members!=null&&members.size()>0){
			 dataMap.put("success", true);
			 dataMap.put("data", members);
		}else{
			 dataMap.put("success", false);
		}
		return SUCCESS;
	}
	
	public String findMembers(){
		dataMap = new HashMap<String, Object>();  
		try{
		List<Member> members=memberService.findAll();
		dataMap.put("members", members);
		// 放入一个是否操作成功的标识  
        dataMap.put("success", true);  
		}catch(Exception e){
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
