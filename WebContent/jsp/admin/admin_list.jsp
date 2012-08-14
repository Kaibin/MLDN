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
<script language="javaScript">
	function conf()
	{
		if(window.confirm("您确定要删除此管理员吗？"))
		{
			return true ;
		}
		return false ;
	}
	function init()
	{
		document.adminForm.adminid.value = "" ;
	}
</script>
<center><jsp:include flush="true" page="../../inc/template.jsp">
	<jsp:param name="url" value="../../" />
</jsp:include> <html:form action="jsp/admin/admin.do" method="post">
管理员ＩＤ：<html:text property="adminid"></html:text>
验证码：<html:text property="checkcode"></html:text>
	<img src="image.jsp">
	<br>
管理员密码：<html:password property="adminpwd"></html:password>
确认密码：<html:password property="confirmpwd"></html:password>
	<br>
	<input type="hidden" name="status" value="insert">
	<input type="hidden" name="type" value="1">
	<html:submit value="添加"></html:submit>
	<html:reset value="重置"></html:reset>
</html:form>
<script language="javaScript">
	document.adminForm.adminid.value = "" ;
	document.adminForm.adminpwd.value = "" ;
	document.adminForm.confirmpwd.value = "" ;
	document.adminForm.checkcode.value = "" ;
</script>
<logic:present name="all" scope="request">
	<table border="0" width="100%">
		<tr>
			<td>编号</td>
			<td>管理员ＩＤ</td>
			<td>是否删除？</td>
		</tr>
		<logic:iterate id="admin" name="all" scope="request">
			<tr>
				<td>${admin.id}</td>
				<td>${admin.adminid}</td>
				<td>
				<html:form action="jsp/admin/admin.do" method="post" onsubmit="return conf()">
					<input type="hidden" name="status" value="delete">
					<input type="hidden" name="type" value="2">
					<input type="hidden" name="adminid" value="${admin.adminid}">
					<html:submit value="删除"></html:submit>
				</html:form>	
				</td>
			</tr>
		</logic:iterate>
	</table>
</logic:present></center>
</body>
</html:html>
