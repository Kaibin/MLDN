<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="true">
<head>
	<title>MLDN ���� �ҵ�������</title>
	<META NAME="Generator" CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
	<META NAME="Author" CONTENT="���˻�">
	<META NAME="Keywords" CONTENT="������,SSH,tomcat,mysql">
	<META NAME="Description" CONTENT="MLDN������վ ���� www.zhinangtuan.net.cn">
</head>
<body>
<center>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../"/>
</jsp:include>
<html:form action="jsp/user.do" method="post">
	�û��ɣģ�<html:text property="userid"></html:text><br>
	�һ�������ʾ���⣺<html:text property="userques"></html:text><br>
	������ʾ����𰸣�<html:text property="userans"></html:text><br>
	��֤�룺<html:text property="checkcode"></html:text><img src="image.jsp"><br>
	<input type="hidden" name="status" value="forgetpwd">
	<input type="hidden" name="type" value="3">
	<html:submit value="�һ�����"></html:submit>
	<html:reset value="����"></html:reset>
	<br>
	<a href="login.jsp">�û���½��</a>
	<a href="register.jsp">�û�ע�᣿</a>
</html:form>
</center>
</body>
</html:html>