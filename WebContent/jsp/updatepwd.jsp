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
<%-- �û��Ѵ��ڣ����Խ��и���������� --%>
<logic:present name="flag" scope="request">
<logic:equal value="exists" name="flag" scope="request">
	<html:form action="jsp/user.do" method="post">
		�µ����룺<html:password property="userpwd"></html:password><br>
		ȷ�����룺<html:password property="confirmpwd"></html:password><br>
		��֤�룺<html:text property="checkcode"></html:text><img src="image.jsp"><br>
		<input type="hidden" name="status" value="updatepwd">
		<input type="hidden" name="type" value="4">
		<input type="hidden" name="userid" value="${param.userid}">
		<html:submit value="��������"></html:submit>
		<html:reset value="����"></html:reset>
		<br>
		<a href="login.jsp">�û���½��</a>
		<a href="register.jsp">�û�ע�᣿</a>
	</html:form>
	<script language="javaScript">
		document.userForm.checkcode.value = "" ;
	</script>
	
</logic:equal>
</logic:present>
</center>
</body>
</html:html>