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
			<td>标题</td>
			<td>提问时间</td>
			<td>点击率</td>
			<td>是否删除？</td>
			<td>是否推荐？</td>
		</tr>
		<logic:iterate id="ques" name="all" scope="request">
			<tr>
				<td><a href="../show.do?qid=${ques.qid}&status=selectid" target="_ablank">${ques.title}</a></td>
				<td>${ques.questiontime}</td>
				<td>${ques.clickcount}</td>
				<td><a href="adminquestion.do?status=delete&qid=${ques.qid}">删除</a></td>
				<td>
					<logic:equal value="0" name="ques" property="commenflag">
						<a href="adminquestion.do?status=commen&qid=${ques.qid}&commen=1">设置推荐</a>
					</logic:equal>
					<logic:equal value="1" name="ques" property="commenflag">
						<a href="adminquestion.do?status=commen&qid=${ques.qid}&commen=0">取消推荐</a>
					</logic:equal>
				</td>
			</tr>
		</logic:iterate>
	</table>
</logic:present></center>
</body>
</html:html>
