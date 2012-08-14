<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="scut.labtalk.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
<sx:head/> 
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Labtalk</title>
<link href="css1.css" rel="stylesheet" type="text/css">
<link href="../css/jquery-css/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="../js/jquery-ui-1.7.2.custom.min.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/list-update.js" type="text/javascript"></script>
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
<SCRIPT type="text/javascript">
	function trim(str) {
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}

	function selectPage(input) {

		var value = trim(input.value);
		if (value == "") {
			return;
		}
		alert(value);
		if (/\d+/.test(value)) {

			input.form.submit();
			return;
		}
		alert("��������ȷ��ҳ��");
		input.focus();

	}
	
</SCRIPT>
</head>
<s:div class="pagech"> 
<s:if test="pagination.totalPage != 0"> 
<s:url action="%{jspUrl}" id="first"> 
<s:param name="pagination.currentPage" value="1" ></s:param> 
<s:param name="%{flagname}" value="flagvalue"></s:param> 
</s:url> 
<s:url action="%{jspUrl}" id="next"  > 
<s:param name="pagination.currentPage" value="pagination.currentPage+1"> </s:param> 
<s:param name="%{flagname}" value="flagvalue"></s:param> 
</s:url> 
<s:url action="%{jspUrl}" id="prior" > 
<s:param name="pagination.currentPage" value="pagination.currentPage-1"></s:param> 
<s:param name="%{flagname}" value="flagvalue"></s:param> 
</s:url> 
<s:url action="%{jspUrl}" id="last"> 
<s:param name="pagination.currentPage" value="pagination.totalPage"></s:param> 
<s:param name="%{flagname}" value="flagvalue"></s:param> 
</s:url> 
<s:if test="pagination.currentPage == 1"> 
<span class="current">��ҳ</span> 
<span class="current">��һҳ</span> 
</s:if> 
<s:else> 
<s:a href="%{first}" >��ҳ</s:a> 
<s:a href="%{prior}" >��һҳ</s:a> 
</s:else> 
<s:if 
test="pagination.currentPage == pagination.totalPage || pagination.totalPage == 0"> 
<span class="current">��һҳ</span> 
<span class="current">ĩҳ</span> 
</s:if> 
<s:else> 
<s:a href="%{next}" id="page_next"  >��һҳ</s:a>&nbsp;&nbsp; 
<s:a href="%{last}" >ĩҳ</s:a> 
</s:else> 
<span class="jumplabel">��ת��</span> 
<s:form action="%{jspUrl}" theme="simple" cssStyle="display:inline" name="spage"> 
<s:hidden name="pagination.totalPage" value="%{pagination.totalPage}"></s:hidden> 
<s:hidden name="%{flagname}" value="flagvalue" />
<input type="text" name="pagination.currentPage" size="2" onblur="selectPage(this)" /> 
</s:form> 

<span class="jumplabel">ҳ</span> 
<span class="jumplabel">��<s:property 
value="pagination.totalRecord" />��</span> 
<span class="jumplabel">��ǰ�ǵ�<s:property 
value="pagination.currentPage" />/<s:property value="pagination.totalPage"/>ҳ</span> 


</s:if> 

</s:div> 