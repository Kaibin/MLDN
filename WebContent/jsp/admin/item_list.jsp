<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
les"%>
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
</jsp:include>
<html:form action="jsp/admin/adminitem.do" method="post">
	栏目名称：<html:text property="itemname"></html:text>
	栏目代码：<html:text property="itemcode" size="2"></html:text>
	<input type="hidden" name="status" value="insert">
	<input type="hidden" name="type" value="1">
	<html:submit value="添加"></html:submit>
</html:form>
<logic:present name="all" scope="request">
	<table border="0" width="80%">
		<tr>
			<td>栏目名称</td>
			<td>优先级别</td>
			<td>修改</td>
			<td>查看子栏目</td>
			<td>删除？</td>
		</tr>
		<logic:iterate id="item" name="all" scope="request">
			<tr>
				<html:form action="jsp/admin/adminitem.do">
				<td><html:text property="itemname" value="${item.itemname}"></html:text></td>
				<td><html:text property="itemcode" value="${item.itemcode}" size="2"></html:text></td>
				<td><html:submit value="修改"></html:submit></td>
				<td><a href="adminitem.do?status=selectid&itemid=${item.itemid}" target="_ablank">查看子栏目</a></td>
				<td><a href="adminitem.do?status=delete&itemid=${item.itemid}">删除</a></td>

				<input type="hidden" name="status" value="update">
				<input type="hidden" name="type" value="2">
				<input type="hidden" name="itemid" value="${item.itemid}">
				</html:form>
			</tr>
		</logic:iterate>
	</table>
</logic:present></center>
</body>
</html:html>
