<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="true">
<head>
	<title>MLDN —— 我的智囊团</title>
	<META NAME="Generator" CONTENT="Struts + Spring + Hibernate + MySQL + Tomcat + CP">
	<META NAME="Author" CONTENT="李兴华">
	<META NAME="Keywords" CONTENT="智囊团,SSH,tomcat,mysql">
	<META NAME="Description" CONTENT="MLDN旗下网站 —— www.zhinangtuan.net.cn">
</head>
<body>
<center>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../"/>
</jsp:include>
<html:form action="jsp/user.do" method="post">
	用户ＩＤ：<html:text property="userid"></html:text><br>
	找回密码提示问题：<html:text property="userques"></html:text><br>
	密码提示问题答案：<html:text property="userans"></html:text><br>
	验证码：<html:text property="checkcode"></html:text><img src="image.jsp"><br>
	<input type="hidden" name="status" value="forgetpwd">
	<input type="hidden" name="type" value="3">
	<html:submit value="找回密码"></html:submit>
	<html:reset value="重置"></html:reset>
	<br>
	<a href="login.jsp">用户登陆？</a>
	<a href="register.jsp">用户注册？</a>
</html:form>
</center>
</body>
</html:html>