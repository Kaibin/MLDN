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

<script type="text/javascript">
$(function () {
	
        	$('a[id^=more_]').click(function(){
        		var param = this.id.replace('more_', '').replace(new RegExp('_', "gm"), '.');
        		if(param == "commen"){
        			location.href = "list_question.jsp?commen=1";
        		}else if(param == "status1"){
        			location.href = "list_question.jsp?status=1";
        		}else if(param == "status2"){
        			location.href = "list_question.jsp?status=2";
        		}
    	 		
         	});
});

</script>


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
</head>
<body>
<jsp:include flush="true" page="../inc/template.jsp">
	<jsp:param name="url" value="../" />
</jsp:include> 
<center>
<div style="margin-bottom: 10px">
<s:if test="#session.userid != null">
	欢迎<s:property value="#session.userid "/>光临&nbsp;
	头衔：<%=IntegralGrade.getInstance().getGradeInfo((Integer) session.getAttribute("grade"))%>&nbsp;
	<a href="user/index.htm">个人中心</a>
</s:if>
</div>
</center>
<div>
<table width="900" cellspacing="0" cellpadding="0" border="0"
	align="center">
	<tbody>
		<tr>
			<td width="200" valign="top">
			<table class="table_index_left" width="100%" cellspacing="0"
				cellpadding="0" border="0">
				<tbody>
					<tr>
						<td class="bg_index_mid" width="100%">问题分类</td>
					</tr>
					<tr>
						<td class="font_index_left" height="50">
						已解决问题数：<s:property value="solveCount"></s:property> <br>
						待解决问题数：<s:property value="unsolveCount"></s:property></td>
					</tr>
					<tr>
						<td>
						<hr width="94%" color="#666666" size="1" align="center" />
						</td>
					</tr>
					<tr>
						<td align="left">
							<s:iterator id="item" value="allitem">
								<table width="200" cellspacing="0" cellpadding="0" border="0">
									<tbody>
										<tr>
											<td height="40" colspan="2">
											<a class="dl" href="MoreItemQuestionAction.action?itemid=${item.itemid}"> <b><s:property value="#item.itemname"/></b> </a></td>
										</tr>
										<s:iterator id="sub" value="#item.subitems" status="status">
										<tr>
											<td width="50%" height="24">
											&nbsp;&nbsp;<a class="xl" href="MoreSubitemQuestionAction.action?itemid=${item.itemid}&subid=${sub.subid}"><s:property value="#sub.subname"/></a>
											</td>
										</tr>
										</s:iterator>
										<tr>
											<td height="1" bgcolor="#006699" colspan="2"/> 
										</tr>
										
									</tbody>
								</table>
							</s:iterator>
						</td>
					</tr>
				</tbody>
			</table>
			</td>
			
			<td width="10"></td>
			
			<td width="490" valign="top">
			<table class="table_index_mid" width="100%" cellspacing="0"
				cellpadding="0" border="0">
				<tbody>
					<tr>
						<td class="bg_index_mid">精彩推荐</td>
					</tr>
					<tr>
						<td>
						<table width="100%" cellspacing="0" cellpadding="0" border="0">
							<tbody>
								<tr>
									<td height="22"><a
										href="list.jtml?dl=Java%BF%AA%B7%A2&xl=%BF%AA%D4%B4%BF%F2%BC%DC">
									<font class="font_fl">[开源框架]</font> </a> <a class="bt"
										target="_blank" href="show/20076/20076252310454525.html">Spring中的
									IoC 和 DI 用白话</a> <img width="22" height="10"
										src="images/hot_point.gif" /></td>
								</tr>
								<tr>
									<td height="22"><a
										href="list.jtml?dl=Java%BF%AA%B7%A2&xl=%BF%AA%D4%B4%BF%F2%BC%DC">
									<font class="font_fl">[开源框架]</font> </a> <a class="bt"
										target="_blank" href="show/20074/20074161815715860.html">Hibernate为什么会出现中文乱码
									</a> <img width="22" height="10" src="images/hot_point.gif" /></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
				</tbody>
			</table>
			
			<table width="100%" cellspacing="0" cellpadding="0" border="0">
				<tbody>
					<tr>
						<td height="8" />
					</tr>
				</tbody>
			</table>

			<table class="table_index_mid" width="100%" cellspacing="0"
				cellpadding="0" border="0">
				<tbody>
					<tr>
						<td><font style="font-size: 14px;"> <b> 未解决的问题</b> &nbsp;<a id="more_status1" href="#">更多</a></font>
						<table width="100%" cellspacing="0" cellpadding="0" border="0">
							<tbody>
								<s:iterator id="ques" value="unsolve">
								<tr>
									<td height="22"><a class="bt" target="_blank"
										href="ShowQuestionAction.action?qid=${ques.qid}"><s:property value="#ques.title"/></a> </td>
								</tr>
								</s:iterator>
							</tbody>
						</table>
						<hr width="94%" color="#666666" size="1" align="center" />

						<font style="font-size: 14px;"> <b>已解决问题</b>&nbsp;<a id="more_status2" href="#">更多</a></font>
						<table width="100%" cellspacing="0" cellpadding="0" border="0">
							<tbody>
								<s:iterator id="ques" value="solve">
								<tr>
									<td height="22"><a class="bt" target="_blank"
										href="ShowQuestionAction.action?qid=${ques.qid}"><s:property value="#ques.title"/></a></td>
								</tr>
								</s:iterator>
							</tbody>
						</table>
						<hr width="94%" color="#666666" size="1" align="center" />


						<font style="font-size: 14px;"> <b>推荐的问题</b>&nbsp;<a id="more_commen" href="#">更多</a> </font>
						<table width="100%" cellspacing="0" cellpadding="0" border="0">
							<tbody>
								<s:iterator id="ques" value="commen">
								<tr>
									<td height="22"><a class="bt" target="_blank"
										href="ShowQuestionAction.action?qid=${ques.qid}"><s:property value="#ques.title"/></a></td>
								</tr>
								</s:iterator>
							</tbody>
						</table>
						<hr width="94%" color="#666666" size="1" align="center" />

						</td>
					</tr>
				</tbody>
			</table>
			</td>

			<td width="10"></td>

			<td width="190" valign="top">
			<table class="table_index_right" width="100%" cellspacing="0"
				cellpadding="0" border="0">
				<tbody>
					<tr>
						<td class="bg_index_right">积分排行榜</td>
					</tr>
					<tr>
						<td align="center">
						<table width="90%" cellspacing="0" cellpadding="0" border="0">
							<tbody>
							<s:iterator id="user" value="allusers" status="status">
								<tr height="26">
									<td><font face="Arial, Helvetica, sans-serif"> <s:property value="#status.index+1"/> <a
										target="_blank" href="showuser.jtml?userid=lixinghua"> <font
										color="#261cdc"><s:property value="#user.userid"></s:property></font> </a> </font></td>
									<td width="30%" align="center"><s:property value="#user.integral"></s:property></td>
								</tr>
								<tr bgcolor="#d9d9d9">
									<td height="1" colspan="2" />
								</tr>
							</s:iterator>	
								<tr>
									<td height="30" colspan="2"></td>
								</tr>
							</tbody>
						</table>
						<table width="100%" cellspacing="0" cellpadding="0" border="0">
							<tbody>
								<tr>
									<td height="8" />
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
				</tbody>
			</table>
			</td>

		</tr>
	</tbody>
</table>
</div>
</body>
</html>