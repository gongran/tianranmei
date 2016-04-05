<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${ctx}/member/css/table.css" />
<script type="text/javascript" src="${ctx }/member/js/jquery-1.12.2 .js"></script>

<script type="text/javascript">
	$(function() {
		// var formParam = $("#form1").serialize();//序列化表格内容为字符串  
				$.ajax({
					type : 'post',
					url : '${ctx}/userAction_findMembers',
					data : null,
					cache : false,
					dataType : 'json',
					success : function(data) {
						var members = data["members"];
						var str = "";
						for ( var i in members) {
							str += "<tr><td><input type=\"checkbox\" name=\"member.id\" value='"+members[i].id+"'/></td><td>"
									+ members[i].kahao
									+ "</td><td>"
									+ members[i].name
									+ "</td><td>"
									+ members[i].sex
									+ "</td><td>"
									+ members[i].age
									+ "</td><td>"
									+ members[i].constellationId
									+ "</td><td>"
									+ members[i].phone + "</td></tr>";
						}
						$("#membersTable").append(str);
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
	<center>
		<table id="membersTable"  class="gridtable" >
			<tr>
				<th><input type="checkbox" id="memberIds" name="memberIds" /></th>
				<th>卡号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>星座</th>
				<th>电话</th>
			</tr>
		</table>
		</center>
	</form>
</body>
</html>