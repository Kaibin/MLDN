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
<center><jsp:include flush="true" page="../../inc/template.jsp">
	<jsp:param name="url" value="../../" />
</jsp:include> <logic:present name="all" scope="request">
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
			<td>����</td>
			<td>�û�ID</td>
			<td>�û��ȼ�</td>
			<td>���ͷ���</td>
			<td>����ʱ��</td>
			<td>���</td>
		</tr>
		<logic:iterate id="question" name="all" scope="request">
			<tr>
				<td><a href="../show.do?qid=${question.qid}&status=selectid">${question.title}</a></td>
				<td>${question.userid}</td>
				<td>${question.grade}</td>
				<td>${question.offerscore}</td>
				<td>${question.questiontime}</td>
				<td>${question.clickcount}</td>
			</tr>
		</logic:iterate>
	</table>
</logic:present></center>
</body>
</html:html>
