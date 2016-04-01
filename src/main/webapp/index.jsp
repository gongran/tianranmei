<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h2>天然美</h2>
<form name="loginForm" action="userAction_loginUser" >
卡号：<s:textfield name="member.kahao"></s:textfield>
密码：<s:password name="member.passWord"></s:password>
<s:submit value="登录"></s:submit>
</form>
</body>
</html>
