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
<jsp:include flush="true" page="../../inc/template.jsp">
	<jsp:param name="url" value="../../" />
</jsp:include>
<logic:present name="question" scope="request">
	������⣺${question.title}<br>
	����ʱ�䣺${question.questiontime}<br>
	�������ݣ�${question.content}<br>
	���ͷ�����${question.offerscore}<br>
	�����ߣ�${question.userid}<br>
	�ȼ���${question.grade}<br>
	<h3>��ѡ�𰸣�</h3>
	<table border="0" width="80%">
		<logic:iterate id="ans" name="question" property="answers">
			<tr>
				<td>�ش��ߣ�</td>
				<td>${ans.userid}</td>
			</tr>
			<tr>
				<td>�ȼ���</td>
				<td>${ans.grade}</td>
			</tr>
			<tr>
				<td>���ݣ�</td>
				<td>${ans.quesans}</td>
			</tr>
			<tr>
				<td colspan="2"><a
					href="userinfo.do?status=acceptanswer&aid=${ans.aid}&uid=${ans.userid}&offerscore=${question.offerscore}">����</a></td>
			</tr>
		</logic:iterate>
	</table>
	<a href="userinfo.do?status=acceptquestion&qid=${question.qid}">���ѹ�</a>
	<a href="userinfo.do?status=questiondo&qid=${question.qid}">�����Ѿ����</a>
	<a href="userinfo.do?status=questionno&qid=${question.qid}">�������</a>
</logic:present>
</body>
</html:html>
