<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="true">
<head>
<title>MLDN ���� �ҵ�������</title>
<META NAME="Generator"
	CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
<META NAME="Author" CONTENT="���˻�">
<META NAME="Keywords" CONTENT="������,SSH,tomcat,mysql">
<META NAME="Description" CONTENT="MLDN������վ ���� www.zhinangtuan.net.cn">
</head>
<body>
<center><logic:present name="all" scope="request">
	<jsp:include page="split_page.jsp">
		<jsp:param name="jspUrl" value="${jspUrl}" />
		<jsp:param name="lineSize" value="${lineSize}" />
		<jsp:param name="allRecorders" value="${allRecorders}" />
		<jsp:param name="keyWord" value="<%=request.getAttribute("keyWord")%>" />
		<jsp:param name="currentPage" value="${currentPage}" />
		<jsp:param name="status" value="${status}" />
		<jsp:param name="searchFlag" value="F" />
	</jsp:include>
	<table border="0" width="100%">
		<tr>
			<td>�û��ɣ�</td>
			<td>����</td>
			<td>E-MAIL</td>
			<td>�Ƿ�ɾ����</td>
		</tr>
		<logic:iterate id="user" name="all" scope="request">
			<tr>
				<td>${user.userid}</td>
				<td><html:form action="jsp/admin/adminuser.do" method="post">
					<html:text property="integral" value="${user.integral}" size="6"></html:text>
					<input type="hidden" name="userid" value="${user.userid}">
					<input type="hidden" name="status" value="updateIntegral">
					<input type="hidden" name="type" value="1">
					<html:submit value="�޸�"></html:submit>
				</html:form></td>
				<td>${user.usermail}</td>
				<td><a href="adminuser.do?status=delete&userid=${user.userid}">ɾ��</a></td>
			</tr>
		</logic:iterate>
	</table>
</logic:present></center>
</body>
</html:html>
