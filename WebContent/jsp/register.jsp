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
	<META NAME="Description" CONTENT="labtalk ���� www.labtalk.com.cn">
</head>
<body>
<center>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../"/>
</jsp:include> 
<h1>�û�ע��</h1>
<s:actionerror />
<s:form action="registerAction.action" method="post">
	<%=basePath%>
	<s:textfield  name="userid" label="�û��ɣ�"></s:textfield>
	<br>
	<s:password name="userpwd" label="�û�����"></s:password>
	<br>
	<s:password name="confirmpwd" label="ȷ������"></s:password>
	<br>
	<s:textfield name="userques" label="��ʧ������ʾ����"></s:textfield>
	<br>
	<s:textfield name="userans" label="��ʧ���������"></s:textfield>
	<br>
	<s:textfield name="checkcode" label="��֤��"></s:textfield>
	<img src="image.jsp"><br>
    <s:hidden name="type" value="1"></s:hidden>
	<s:submit value="ע��"></s:submit>
	<s:reset value="����"></s:reset>
</s:form>
</center>
</body>
</html>
