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
</jsp:include> 
<logic:present name="flag" scope="request">
	<logic:equal value="error" name="flag" scope="request">
		<h3>�������ִ���</h3>
	</logic:equal>
</logic:present>
<script langugage="javaScript">
	function validate(userForm)
	{
		if(userForm.userpwd.value=="")
		{
			alert("���벻��Ϊ�գ�") ;
			userForm.userpwd.focus() ;
			return false ;
		}
		if(!(userForm.userpwd.value==userForm.confirmpwd.value))
		{
			alert("������������벻һ�£�") ;
			userForm.confirmpwd.focus() ;
			return false ;
		}
		return true ;
	}
</script>

<logic:present name="user" scope="request">
	<html:form action="jsp/user.do" method="post" onsubmit="return validate(this)">
		<table border="0" width="100%">
			<tr>
				<td colspan="2">�û�ID��${user.userid}&nbsp; �ȼ���${grade}&nbsp;
				���֣�${user.integral}</td>
			</tr>
			<tr>
				<td>��½���룺</td>
				<td><html:password property="userpwd"></html:password></td>
			</tr>
			<tr>
				<td>ȷ�����룺</td>
				<td><html:password property="confirmpwd"></html:password></td>
			</tr>
			<tr>
				<td>�һ�������ʾ���⣺</td>
				<td><html:text property="userques" value="${user.userques}"></html:text></td>
			</tr>
			<tr>
				<td>������ʾ����𰸣�</td>
				<td><html:text property="userans" value="${user.userans}"></html:text></td>
			</tr>
			<tr>
				<td>��ʵ������</td>
				<td><html:text property="realname"  value="${user.realname}"></html:text></td>
			</tr>
			<tr>
				<td>�Ա�</td>
				<td><logic:equal value="��" name="user" property="sex">
					<input type="radio" name="sex" value="��" checked>��
			<input type="radio" name="sex" value="Ů">Ů
			</logic:equal> <logic:equal value="Ů" name="user" property="sex">
					<input type="radio" name="sex" value="��">��
			<input type="radio" name="sex" value="Ů" checked>Ů
			</logic:equal></td>
			</tr>
			<tr>
				<td>E-MAIL��</td>
				<td><html:text property="usermail" value="${user.usermail}"></html:text></td>
			</tr>
			<tr>
				<td>��֤�룺</td>
				<td><html:text property="checkcode"></html:text> <img
					src="image.jsp"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="status"
					value="update"> <input type="hidden" name="type" value="1">
				<input type="hidden" name="userid" value="${user.userid}"> <input
					type="hidden" name="integral" value="${user.integral}"> <input
					type="hidden" name="grade" value="${user.grade}"> <html:submit
					value="����"></html:submit> <html:reset value="����"></html:reset></td>
			</tr>
		</table>
	</html:form>
</logic:present></center>
</body>
</html:html>
