<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="true">
<head>
	<title>labtalk</title>
	<META NAME="Generator" CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
	<META NAME="Author" CONTENT="kaibin">
	<META NAME="Keywords" CONTENT="labtalk,SSH,tomcat,mysql">
	<META NAME="Description" CONTENT="labtalk —— www.labtalk.com.cn">
<link href="css1.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
</head>
<body>
<center>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../"/>
</jsp:include>
<s:actionerror />
<s:form action="loginAction.action" method="post">
	<%=basePath%>
	<s:textfield  name="userid" label="用户ＩＤ"></s:textfield>
	<br>
	<s:password name="userpwd" label="用户密码"></s:password>
	<br>
	<s:textfield name="checkcode" label="验证码"></s:textfield>
	<img src="image.jsp"><br>
    <s:hidden name="type" value="2"></s:hidden>
	<s:submit value="登陆"></s:submit>
	<s:reset value="重置"></s:reset>
	<br>
	<a href="register.jsp">注册新用户？</a>
	<a href="forgetpwd.jsp">忘记密码？</a>
</s:form>
</center>
</body>
</html>