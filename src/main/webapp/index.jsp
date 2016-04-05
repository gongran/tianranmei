<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/table.css" />
<script type="text/javascript" src="${ctx }/member/js/jquery-1.12.2 .js"></script>
<script type="text/javascript">
	$(function() {
		$("#dl").click(function() {
			$.ajax({
				type : 'post',
				url : '${ctx}/userAction_loginUser',
				data : $("form[name='loginForm']").serialize(),
				cache : false,
				dataType : 'json',
				success : function(data) {
					var con = data["success"];
					if (con) {
						alert("登录成功！");
						window.location="${ctx }/userAction_toMember";
					} else {
						alert("卡号密码不匹配！");
					}
				}
			});
		});
	});
</script>
<html>
<body>
	<form name="loginForm" action="userAction_loginUser">
		<center>
			<table class="gridtable" width="50px">
				<tr>
					<th colspan="2"><h2>天然美会员管理系统</h2></th>
				</tr>
				<tr>
					<td>卡号：</td>
					<td><input name="member.kahao" type="text" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input name="member.passWord" type="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input id="dl" type="button" value="登录" /></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>
