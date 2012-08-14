<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="scut.labtalk.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
<s:iterator id="item" value="allitem" >
		<a href="show.do?itemid=${item.itemid}&status=selectitem">${item.itemname}</a>
		<br>
		|- 
		<s:iterator id="sub" value="#item.subitems" >
			<a
				href="show.do?itemid=${item.itemid}&subid=${sub.subid}&status=selectsub">${sub.subname}</a>|
		</s:iterator>
		<br>
	</s:iterator>
<table border="0" width="100%">
		<tr>
			<td width=200px>标题</td>
			<td width=150px>用户ID</td>
			<td width=150px>用户等级</td>
			<td width=150px>悬赏分数</td>
			<td width=150px>提问时间</td>
			<td width=150px>点击</td>
		</tr>
		<s:iterator id="question" value="allques">
			<tr>
				<td width=200px><a href="show.do?qid=${question.qid}&status=selectid">${question.title}</a></td>
				<td width=150px>${question.userid}</td>
				<td width=150px>${question.grade}</td>
				<td width=150px>${question.offerscore}</td>
				<td width=150px>${question.questiontime}</td>
				<td width=150px>${question.clickcount}</td>
			</tr>
		</s:iterator>
	</table>
<s:include value="pagination.jsp"></s:include>
</div>