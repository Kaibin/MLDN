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
	<META NAME="Description" CONTENT="labtalk ���� www.labtalk.com.cn">
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
	<s:textfield  name="userid" label="�û��ɣ�"></s:textfield>
	<br>
	<s:password name="userpwd" label="�û�����"></s:password>
	<br>
	<s:textfield name="checkcode" label="��֤��"></s:textfield>
	<img src="image.jsp"><br>
    <s:hidden name="type" value="2"></s:hidden>
	<s:submit value="��½"></s:submit>
	<s:reset value="����"></s:reset>
	<br>
	<a href="register.jsp">ע�����û���</a>
	<a href="forgetpwd.jsp">�������룿</a>
</s:form>
</center>
</body>
</html>