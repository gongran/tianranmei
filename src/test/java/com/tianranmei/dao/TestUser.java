package com.tianranmei.dao;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestUser{
	@Autowired
	private IdentityService identityService;
	@Test
	public void addUser(){
		User user=identityService.newUser("henryyan");
		user.setFirstName("Henry");
		user.setLastName("Yan");
		user.setEmail("aaa@foxmail.com");
		identityService.saveUser(user);
		
		User acer=identityService.createUserQuery().userId("henryyan").singleResult();
		System.out.println(acer.getFirstName());
	}
	@Test
	public void deleteUser(){
		identityService.deleteUser("henryyan");
	}
	@Test
	public void allUser(){
		List<User> users=identityService.createUserQuery().list();
		for(User user:users){
			System.out.println("用户名："+user.getFirstName());
		}
	}
}
