<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>  

<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="true">
<head>
	<title>labtalk</title>
	<META NAME="Generator" CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
	<META NAME="Author" CONTENT="kaibin">
	<META NAME="Keywords" CONTENT="labtalk,SSH,tomcat,mysql">
	<META NAME="Description" CONTENT="labtalk ���� www.labtalk.com.cn">
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link href="css1.css" rel="stylesheet" type="text/css">
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
</head>
<body>
<center>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../" />
</jsp:include> 

 <div style="text-align:left" class="comt"  ><s:property value="question.title"/></div>
	<table class="comt" width="100%" border="0" >
		<tr>
			<td>
			�����ڣ�<s:property value="question.questiontime"/> &nbsp;&nbsp;
			�����ˣ�<s:property value="question.userid"/>&nbsp;&nbsp; �ȼ���<s:property value="question.grade"/>
			</td>
		</tr>
		<tr>
			<td><s:property value="question.content"/></td>
		</tr>
	</table>
	<s:iterator id="ans" value="question.answers">
		<table class="comt" border="0" width="100%"> 
			<tr>
				<td colspan="2">�����ڣ�<s:property value="#ans.anstime"/>&nbsp;&nbsp;
				�ظ��ˣ� <s:property value="#ans.userid"/>&nbsp;&nbsp; �ȼ���<s:property value="#ans.grade"/></td>
			</tr>
			<tr> 
				<td colspan="2"><s:property value="#ans.quesans"/></td>
			</tr>
		</table>
	</s:iterator>
	<table class="comt"  >
		<tr>
			<td>
			<s:form action="AnswerAction.action" method="post">
			�ظ�����     �����û����ܷ���ظ���<br><br>
			<s:textarea name="quesans" class="editor" style="height: 280px; width: 700px; display:none"></s:textarea>
			<FCK:editor instanceName="quesans" basePath="/FCKeditor" > 
			</FCK:editor>  
			<br>
			<s:textfield name="checkcode" label="��֤��"></s:textfield>	<img src="image.jsp">
			<br>
			<s:hidden name="qid" value="%{question.qid}"></s:hidden>
			<s:hidden name="type" value="1"></s:hidden>
			<s:hidden name="userid" value="%{#session.userid}"></s:hidden>
			<s:hidden name="grade" value="%{#session.grade}"></s:hidden>
			<s:submit value="�ύ�ظ�" style="float:left"></s:submit>
			</s:form>
			</td>
		</tr>
	</table>

</center>
</body>
</html>
