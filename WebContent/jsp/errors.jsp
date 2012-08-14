<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="true">
<head>
	<title>labtalk</title>
	<META NAME="Generator" CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
	<META NAME="Author" CONTENT="kaibin">
	<META NAME="Keywords" CONTENT="labtalk,SSH,tomcat,mysql">
	<META NAME="Description" CONTENT="labtalk —— www.labtalk.com.cn">
	<META HTTP-EQUIV="refresh" CONTENT="4;URL=../IndexAction.action">
<link href="../css1.css" rel="stylesheet" type="text/css">
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
<h1>程序出现了以下错误</h1>
<s:actionerror />
</center>
</body>
</html>