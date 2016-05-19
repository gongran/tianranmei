<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css"
	href="${ctx}/member/css/table.css" />
<script type="text/javascript" src="${ctx }/member/js/jquery-1.12.2 .js"></script>

<script type="text/javascript">
	$(function() {
		$("#bc").click(function() {
			$.ajax({
				type : 'post',
				url : '${ctx}/userAction_addOrUpdateMember',
				data : $("form[name='editMemberForm']").serialize(),
				cache : false,
				dataType : 'json',
				success : function(data) {
					var con = data["success"];
					var mid="${member.id }";
					if (con) {
						mid==""?alert("添加成功！"):alert("修改成功！");
					} else {
						mid==""?alert("添加失败！"):alert("修改成功！");
					}
				}
			});
		});

	});
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
</head>
<body>
	<form name="editMemberForm" action="userAction_editMember">
	<input type="hidden" name="member.id" value="${member.id }"/>
		<center>
			<table class="membertable">
				<tr>
					<th colspan="2" align="center"><h2>会员资料</h2></th>
				</tr>
				<tr>
					<th>姓名：</th>
					<td><input name="member.name" type="text" readonly="readonly"
						value="${member.name }" /></td>
				</tr>
				<tr>
					<th>卡号：</th>
					<td><input name="member.kahao" type="text" readonly="readonly"
						value="${member.kahao }" /></td>
				</tr>
				<tr>
					<th>性别：</th>
					<td><%-- <input name="member.sex" type="text" readonly="readonly"
						value="${member.sex=='1'?'男':'女' }" /> --%>
						<select name="member.sex" >
						<option value="1" ${member.sex=='1'?'selected = \"selected\"':''  }>男</option>
						<option value="0" ${member.sex=='0'?'selected = \"selected\"':''  }>女</option>
						
						</select>
						</td>
				</tr>
				<tr>
					<th>生日：</th>
					<td><input name="member.age" type="text" readonly="readonly"
						value="${member.age }" /></td>
				</tr>
				<tr>
					<th>电话：</th>
					<td><input name="member.phone" type="text"
						value="${member.phone }" /></td>
				</tr>
				<tr>
					<th>备注：</th>
					<td><input name="member.des" type="text"
						value="${member.des }" /></td>
				</tr>
				<tr>
					<th></th>
					<td align="left"><input id="bc" type="button" value="保存" /></td>
				</tr>
			</table>
			<s:debug></s:debug>
		</center>
	</form>
</body>
</html>