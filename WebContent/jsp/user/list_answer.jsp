<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="true">
<head>
<title>MLDN —— 我的智囊团</title>
<META NAME="Generator"
	CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
<META NAME="Author" CONTENT="李兴华">
<META NAME="Keywords" CONTENT="智囊团,SSH,tomcat,mysql">
<META NAME="Description" CONTENT="MLDN旗下网站 —— www.zhinangtuan.net.cn">
</head>
<body>
<jsp:include flush="true" page="../../inc/template.jsp">
	<jsp:param name="url" value="../../" />
</jsp:include>
<logic:present name="question" scope="request">
	问题标题：${question.title}<br>
	提问时间：${question.questiontime}<br>
	提问内容：${question.content}<br>
	悬赏分数：${question.offerscore}<br>
	提问者：${question.userid}<br>
	等级：${question.grade}<br>
	<h3>被选答案：</h3>
	<table border="0" width="80%">
		<logic:iterate id="ans" name="question" property="answers">
			<tr>
				<td>回答者：</td>
				<td>${ans.userid}</td>
			</tr>
			<tr>
				<td>等级：</td>
				<td>${ans.grade}</td>
			</tr>
			<tr>
				<td>内容：</td>
				<td>${ans.quesans}</td>
			</tr>
			<tr>
				<td colspan="2"><a
					href="userinfo.do?status=acceptanswer&aid=${ans.aid}&uid=${ans.userid}&offerscore=${question.offerscore}">采纳</a></td>
			</tr>
		</logic:iterate>
	</table>
	<a href="userinfo.do?status=acceptquestion&qid=${question.qid}">答案已够</a>
	<a href="userinfo.do?status=questiondo&qid=${question.qid}">问题已经解决</a>
	<a href="userinfo.do?status=questionno&qid=${question.qid}">无满意答案</a>
</logic:present>
</body>
</html:html>
