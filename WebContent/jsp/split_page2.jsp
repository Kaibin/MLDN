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
<script language="javascript" type="text/javascript">
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
	function change() 
	{
		if(document.searchPage.keyWord.value!="")
		{
			 alert(document.searchPage.keyWord.value) ;
		}
	}
</script>
</head>

<s:if test=' {#searchFlag=="F"} '>
</s:if>

<s:form name="spage" method="post" action="%{jspUrl}" onSubmit="change()" >
<s:if test="pagination.totalPage > 0">   
    <input type="button" value="首页"  onClick="openPage(1)"> 
	<input type="button" value="上一页" onClick="openPage(<s:property value="pagination.currentPage"/> -1)" <s:if test="pagination.currentPage == 1 "> "disabled"</s:if> > 
	<input type="button" value="下一页" onClick="openPage(<s:property value="pagination.currentPage"/> +1)" <s:if test="pagination.currentPage == pagination.totalPage "> "disabled"</s:if> > 
	<input type="button" value="最后一页" onClick="openPage(<s:property value="pagination.totalPage"/>)" <s:if test="pagination.currentPage == pagination.totalPage "> "disabled"</s:if> >  
	<s:hidden name="cp" value="1"></s:hidden>
	<s:hidden name="%{flagname}" value="%{flagvalue}" />
	<font color="red" size="5"><s:property value="pagination.currentPage"></s:property></font>
/   <font color="red" size="5"><s:property value="pagination.totalPage"></s:property></font>
	跳转到 
	
	<!--<s:select name="selpage" header="1" headerValue="1" list="pageList" onChange="selOpenPage()">
	</s:select>
	-->
		 <select name="selpage" onChange="selOpenPage()">
			<s:iterator id="stat" value="pageList">
			<option value="<s:property value="#stat" />"><s:property value="#stat" /> </option>
			</s:iterator>
		</select>
	</s:if>  
</s:form>
</html>