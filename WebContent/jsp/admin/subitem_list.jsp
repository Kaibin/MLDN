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
<jsp:include flush="true" page="../../inc/template.jsp">
	<jsp:param name="url" value="../../"/>
</jsp:include> 
<logic:present name="item" scope="request">
<h2>${item.itemname}������Ŀ��</h2>
<html:form action="jsp/admin/adminsubitem.do" method="post">
	����Ŀ���ƣ�<html:text property="subname"></html:text>
	����Ŀ���룺<html:text property="subcode" size="2"></html:text>
	<input type="hidden" name="itemid" value="${item.itemid}">
	<input type="hidden" name="status" value="insert">
	<input type="hidden" name="type" value="1">
	<html:submit value="���"></html:submit>
</html:form>
	<table border="0" width="80%">
		<tr>
			<td>����Ŀ����</td>
			<td>���ȼ���</td>
			<td>�޸�</td>
			<td>ɾ����</td>
		</tr>
		<logic:iterate id="subitem" name="item" scope="request" property="subitems">
			<tr>
				<html:form action="jsp/admin/adminsubitem.do">
				<td><html:text property="subname" value="${subitem.subname}"></html:text></td>
				<td><html:text property="subcode" value="${subitem.subcode}" size="2"></html:text></td>
				<td><html:submit value="�޸�"></html:submit></td>
				<td><a href="adminsubitem.do?status=delete&subid=${subitem.subid}&itemid=${item.itemid}">ɾ��</a></td>
				<input type="hidden" name="subid" value="${subitem.subid}">
				<input type="hidden" name="status" value="update">
				<input type="hidden" name="type" value="2">
				<input type="hidden" name="itemid" value="${item.itemid}">
				</html:form>
			</tr>
		</logic:iterate>
	</table>
</logic:present>
</center>
</body>
</html:html>