package com.tianranmei.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianranmei.action.UsersAction;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestTest {

	@Autowired
	private UsersAction usersAction;
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Test
	public void test() {
//		repositoryService.createDeployment().addClasspathResource("processXML/process.bpmn20.xml").deploy();
		List<ProcessDefinition> processDefinitions=repositoryService.createProcessDefinitionQuery().list();
		for(ProcessDefinition processDefinition : processDefinitions){
			System.out.println(processDefinition.getDeploymentId());
			repositoryService.deleteDeployment(processDefinition.getDeploymentId());
		}
		
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("process");
		assertNotNull(processInstance);
		System.out.println("pid="+processInstance.getId()+", pdid="+processInstance.getProcessDefinitionId());
		
//		   process:1:7504
//		   process:2:10004
//		   process:3:15004
//		   process:4:17504
//		   process:5:17508
//		   process:6:20004
	}
	/**
	 * 部署流程
	 * 
	 */
	@Test
	public void deploymentProcess(){
		repositoryService.createDeployment().addClasspathResource("processXML/process.bpmn").deploy();
	}
	/**
	 * 启动流程
	 */
	@Test
	public void startProcess(){
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("process");
		assertNotNull(processInstance);
		System.out.println("pid="+processInstance.getId()+", pdid="+processInstance.getProcessDefinitionId());
	}
	/**
	 * 查询所有的流程部署
	 */
	@Test
	public void allDeployment(){
		List<ProcessDefinition> processDefinitions=repositoryService.createProcessDefinitionQuery().list();
		for(ProcessDefinition processDefinition : processDefinitions){
			System.out.println("流程定义id="+processDefinition.getDeploymentId()+" key="+processDefinition.getKey());
		}
	}
	/**
	 * 删除所有流程部署
	 */
	@Test
	public void deleteAllDeployment(){
		List<ProcessDefinition> processDefinitions=repositoryService.createProcessDefinitionQuery().list();
		for(ProcessDefinition processDefinition : processDefinitions){
			System.out.println("删除流程部署="+processDefinition.getDeploymentId());
			repositoryService.deleteDeployment(processDefinition.getDeploymentId(),true);
		}
	}
	

}
