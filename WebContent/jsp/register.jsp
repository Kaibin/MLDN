<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="true">
<head>
	<title>labtalk</title>
	<META NAME="Generator" CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
	<META NAME="Author" CONTENT="kaibin">
	<META NAME="Keywords" CONTENT="labtalk,SSH,tomcat,mysql">
	<META NAME="Description" CONTENT="labtalk —— www.labtalk.com.cn">
</head>
<body>
<center>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../"/>
</jsp:include> 
<h1>用户注册</h1>
<s:actionerror />
<s:form action="registerAction.action" method="post">
	<%=basePath%>
	<s:textfield  name="userid" label="用户ＩＤ"></s:textfield>
	<br>
	<s:password name="userpwd" label="用户密码"></s:password>
	<br>
	<s:password name="confirmpwd" label="确认密码"></s:password>
	<br>
	<s:textfield name="userques" label="丢失密码提示问题"></s:textfield>
	<br>
	<s:textfield name="userans" label="丢失密码问题答案"></s:textfield>
	<br>
	<s:textfield name="checkcode" label="验证码"></s:textfield>
	<img src="image.jsp"><br>
    <s:hidden name="type" value="1"></s:hidden>
	<s:submit value="注册"></s:submit>
	<s:reset value="重置"></s:reset>
</s:form>
</center>
</body>
</html>
