<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="true">
<head>
<title>MLDN —— 我的智囊团</title>
<META NAME="Generator"
	CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
<META NAME="Author" CONTENT="李兴华">
<META NAME="Keywords" CONTENT="智囊团,SSH,tomcat,mysql">
<META NAME="Description" CONTENT="MLDN旗下网站 —— www.zhinangtuan.net.cn">
</head>
<body>
<center><jsp:include flush="true" page="../../inc/template.jsp">
	<jsp:param name="url" value="../../" />
</jsp:include> 
<logic:present name="flag" scope="request">
	<logic:equal value="error" name="flag" scope="request">
		<h3>操作出现错误！</h3>
	</logic:equal>
</logic:present>
<script langugage="javaScript">
	function validate(userForm)
	{
		if(userForm.userpwd.value=="")
		{
			alert("密码不能为空！") ;
			userForm.userpwd.focus() ;
			return false ;
		}
		if(!(userForm.userpwd.value==userForm.confirmpwd.value))
		{
			alert("两次输入的密码不一致！") ;
			userForm.confirmpwd.focus() ;
			return false ;
		}
		return true ;
	}
</script>

<logic:present name="user" scope="request">
	<html:form action="jsp/user.do" method="post" onsubmit="return validate(this)">
		<table border="0" width="100%">
			<tr>
				<td colspan="2">用户ID：${user.userid}&nbsp; 等级：${grade}&nbsp;
				积分：${user.integral}</td>
			</tr>
			<tr>
				<td>登陆密码：</td>
				<td><html:password property="userpwd"></html:password></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><html:password property="confirmpwd"></html:password></td>
			</tr>
			<tr>
				<td>找回密码提示问题：</td>
				<td><html:text property="userques" value="${user.userques}"></html:text></td>
			</tr>
			<tr>
				<td>密码提示问题答案：</td>
				<td><html:text property="userans" value="${user.userans}"></html:text></td>
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td><html:text property="realname"  value="${user.realname}"></html:text></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><logic:equal value="男" name="user" property="sex">
					<input type="radio" name="sex" value="男" checked>男
			<input type="radio" name="sex" value="女">女
			</logic:equal> <logic:equal value="女" name="user" property="sex">
					<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女" checked>女
			</logic:equal></td>
			</tr>
			<tr>
				<td>E-MAIL：</td>
				<td><html:text property="usermail" value="${user.usermail}"></html:text></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><html:text property="checkcode"></html:text> <img
					src="image.jsp"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="status"
					value="update"> <input type="hidden" name="type" value="1">
				<input type="hidden" name="userid" value="${user.userid}"> <input
					type="hidden" name="integral" value="${user.integral}"> <input
					type="hidden" name="grade" value="${user.grade}"> <html:submit
					value="更新"></html:submit> <html:reset value="重置"></html:reset></td>
			</tr>
		</table>
	</html:form>
</logic:present></center>
</body>
</html:html>
