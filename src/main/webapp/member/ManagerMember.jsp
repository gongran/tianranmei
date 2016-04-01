<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
var a="${pageContext.request.contextPath}";
alert(a);
</script>
<script type="text/javascript" src="${ctx}/member/js/jquery-1.12.2 .js"></script>
<script type="text/javascript">
$(function(){
	// var formParam = $("#form1").serialize();//序列化表格内容为字符串  
	    $.ajax({  
	          type:'post',      
	          url:'${ctx}/userAction_findMembers',  
	          data:null,  
	          cache:false,  
	          dataType:'json',  
	          success:function(data){
		            alert("ok");
	        }  
	      }); 
});
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
</head>
<body>
<form action="userAction_editMember">
<table id="members">
<tr><td>全选<input type="checkbox" id="memberIds" name="memberIds"/></td><td>卡号</td><td>姓名</td><td>性别</td><td>年龄</td><td>星座</td><td>电话</td></tr>
<c:forEach  items="${activityPages}" var="list">
<tr><td><input type="checkbox" name="member.id"/></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
</c:forEach>
</table>
</form>
</body>
</html>