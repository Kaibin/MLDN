<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="scut.labtalk.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Labtalk</title>

<link href="css1.css" rel="stylesheet" type="text/css">
<link href="../css/jquery-css/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="../js/jquery-ui-1.7.2.custom.min.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/json.js" type="text/javascript"></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script language="javascript" >
	function change()
	{
		if(document.searchForm.keyWord.value!="")
		{
			 //alert(document.searchForm.keyWord.value) ;
		}
	}
	function openPage(curpage)
	{
		document.spage.cp.value = curpage ;
		 alert(curpage) ;
		document.spage.submit() ;
	}
	function selOpenPage()
	{
		document.spage.cp.value = document.spage.selpage.value ;
		 alert(document.spage.selpage.value) ;
		document.spage.submit() ;
	}
</script>
</head>
<body>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../" />
</jsp:include>
<center>
<!-- 
<s:form id="searchForm" name="searchForm" method="post" action="SearchQuestionAction.action"
onSubmit="change()" >
<s:textfield id="keyWord" name="keyWord" label="search" maxlength="255" style="width:200px"></s:textfield>
<s:hidden name="pagination.totalPage" value="%{pagination.totalPage}"></s:hidden>
<s:hidden name="jspUrl" value="SearchQuestionAction.action"></s:hidden>
<s:submit value="Search"></s:submit>
<br>
</s:form>
 -->

<input type="text" name="keyWord" id="keyWord" value="">

</center>
<table id = "tques" border="0" width="100%">
	<tbody>
	<tr>
			<td width=200px>标题</td>
			<td width=150px>用户ID</td>
			<td width=150px>用户等级</td>
			<td width=150px>悬赏分数</td>
			<td width=150px>提问时间</td>
			<td width=150px>点击</td>
		</tr>
	</tbody>	
	</table>
	<form id="page" action="">
	<input type="hidden" id="cp" name="pagination.currentPage",value=""/>
	<a class="current" id="first_page" href="#">首页</a>&nbsp;&nbsp;
	<a class="current" id="prior_page" href="#">上一页</a>&nbsp;&nbsp;  
	<a class="current" id="next_page" href="#">下一页</a>&nbsp;&nbsp; 
	<a class="current" id="last_page" href="#">最后一页</a>&nbsp;&nbsp;
	</form>
</body>
</html>
