<%@ page contentType="text/html;charset=gbk"%>
<%
	// ҳ������·��
	String jspUrl = null ;
	// �������·�ҳ����
	// 1������ûҳҪ��ʾ�ļ�¼����Ĭ����10��ÿҳ
	int lineSize = 10 ;
	// 2������һ����ǰ�ǵڼ�ҳ
	int currentPage = 1 ;
	// �������ҳ��
	int pageSize = 0 ;
	// �ܼ�¼�� / ÿҳ��ʾ�ļ�¼��
	int allRecorders = 0 ;
	// �����ѯ�ؼ��ֱ���
	String keyWord = null ;
	// ����һ���������
	String searchFlag = "F" ;
%>
<%
	// ��Ҫ������������²���
	// ��ǰҳ��ÿҳ��ʾ�ļ�¼�����ܼ�¼������ѯ�ؼ��֡����ӵ�ַ
	jspUrl = request.getParameter("jspUrl") ;
	keyWord = request.getParameter("keyWord") ;
	searchFlag = request.getParameter("searchFlag") ;
	try
	{
		lineSize = Integer.parseInt(request.getParameter("lineSize")) ;
		currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
		allRecorders = Integer.parseInt(request.getParameter("allRecorders")) ;
	}
	catch(Exception e)
	{
		// s
	}
%>
<%
	// ������ҳ��
	pageSize = (allRecorders+lineSize-1)/lineSize ;
%>
<script language="javaScript">
	function openPage(curpage)
	{
		document.spage.cp.value = curpage ;
		// alert(cupage) ;
		document.spage.submit() ;
	}
	function selOpenPage()
	{
		document.spage.cp.value = document.spage.selpage.value ;
		document.spage.submit() ;
	}
	function change()
	{
		if(document.spage.kw.value!="")
		{
			document.spage.status.value = "selectlike" ;
		}
	}
</script>
<form name="spage" action="<%=jspUrl%>" onSubmit="change()">
<input type="hidden"
	name="status" value="${status}"> <input type="hidden"
	name="${param.flagname}" value=${param.flagvalue}> <%
 if ("T".equals(searchFlag)) {
 %> �����ѯ�ؼ��֣�<input type="text" name="kw"
	value="<%=keyWord.equals("null") ? "" : keyWord%>"> <input
	type="submit" value="��ѯ"> <br>
<br>
<%
}
%> <%
 if (allRecorders > 0) {
 %> <input type="button" value="��ҳ" onClick="openPage(1)"
	<%=currentPage == 1 ? "disabled" : ""%>> <input type="button"
	value="��һҳ" onClick="openPage(<%=currentPage - 1%>)"
	<%=currentPage == 1 ? "disabled" : ""%>> <input type="button"
	value="��һҳ" onClick="openPage(<%=currentPage + 1%>)"
	<%=currentPage == pageSize ? "disabled" : ""%>> <input type="button"
	value="βҳ" onClick="openPage(<%=pageSize%>)"
	<%=currentPage == pageSize ? "disabled" : ""%>> <input type="hidden"
	name="cp" value=""> <font color="red" size="5"><%=currentPage%></font>
/ <font color="red" size="5"><%=pageSize%></font> ��ת�� <select
	name="selpage" onChange="selOpenPage()">
	<%
	for (int x = 1; x <= pageSize; x++) {
	%>
	<option value="<%=x%>" <%=currentPage == x ? "selected" : ""%>><%=x%></option>
	<%
	}
	%>
</select> ҳ <%
}
%>
</form>
