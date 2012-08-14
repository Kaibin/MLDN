<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="true">
<head>
	<title>labtalk</title>
	<META NAME="Generator" CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
	<META NAME="Author" CONTENT="kaibin">
	<META NAME="Keywords" CONTENT="labtalk,SSH,tomcat,mysql">
	<META NAME="Description" CONTENT="labtalk —— www.labtalk.com.cn">
</head>
<title>Labtalk</title>
<link href="../css1.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.comt {
border:1px solid #A9CBEE;
float:left;
padding:10px 0 2px 10px;
width:960px;
}
.editor {
border:1px solid #9B9B9B;
color:Black;
font-size:14px;
padding:3px 0;
width:100%;
}
-->
</style>
<body>
<center><jsp:include flush="true" page="../../inc/template.jsp">
	<jsp:param name="url" value="../../" />
</jsp:include> 
	
	<table class="comt"  >
	<tbody>
	<tr>
		<td>
		<s:form action="QuestionAction.action" method="post" name="form1">
		<s:textfield  name="title" label="标题"></s:textfield>
		<s:doubleselect label="栏目" 
			list="itemList"  name="itemid" listKey="itemid" listValue="itemname"
			doubleName="subid" doubleList="itemMap.get(top.itemid)" doubleListKey="subid" doubleListValue="subname"  />
		<s:text name="内容"></s:text> 
		<s:textarea name="content" class="editor" style="height: 280px; width: 700px; display:none"></s:textarea>
			<FCK:editor instanceName="content" basePath="/FCKeditor" > 
			</FCK:editor>  
		<s:textfield name="offerscore" label="悬赏分数"></s:textfield>
		<s:textfield name="checkcode" label="验证码"></s:textfield>
		<img src="image.jsp">
		<s:hidden name="type" value="1"></s:hidden>
		<s:hidden name="userid" value="%{#session.userid}"></s:hidden>
		<s:hidden name="grade" value="%{#session.grade}"></s:hidden>
		<s:submit value="提交" style="float:left"></s:submit>
		</s:form>
		</td>
		</tr>
		</tbody>
		</table>
	
</center>
</body>
</html>
