<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ page import="java.util.*"%>
<%@ page import="scut.labtalk.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


	<html>
	<head>
		<title>labtallk</title>
		<link rel="stylesheet" type="text/css" href="../css/flexigrid_gray.css">
		<link rel="stylesheet" type="text/css" href="../jqModal/css/jqModal_gray.css">
		<script type="text/javascript" src="../js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="../js/flexigrid.js"></script>
		<script type="text/javascript" src="../jqModal/dimensions.js"></script>
		<script type="text/javascript" src="../jqModal/jqDnR.js"></script>
		<script type="text/javascript" src="../jqModal/jqModal.js"></script>
		<script type="text/javascript" src="js/test.js"></script>
	</head>
<body>
<table id="flex" style="display: none"></table>
<div class="jqmWindow" style="width: 300px;" id="goods">
			<div class="drag">
				商品信息编辑
				<div class="close"></div>
			</div>
			<form id="savegoods" method="post">
				<table width="252" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>ID：</td>
						<td><input type="text" name="id" ></td>
					</tr>
					<tr>
						<td>商品名称：</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>标准：</td>
						<td><input type="text" name="stand"></td>
					</tr>
					<tr>
						<td>单价：</td>
						<td><input type="text" name="money"></td>
					</tr>
					<tr>
						<td>库存：</td>
						<td><input type="text" name="leavings"></td>
					</tr>
					<tr>
						<td>已经订购：</td>
						<td><input type="text" name="orders"></td>
					</tr>
				</table>
				<div align="center">
					<input type="button" id="submit" class="input-button" value="提交" />
					<input type="reset" class="input-button" value="重置" />
				</div>
			</form>
</div>
</body>
</html>