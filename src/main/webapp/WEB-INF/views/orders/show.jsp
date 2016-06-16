<%@page import="com.cnblogs.yjmyzz.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/views/common/meta.jsp"%>
<head>
<meta charset="utf-8">
<title>Order ${id}</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="page-header">
					<h1>Order ${id}</h1>
				</div>
				<table class="table table-striped">
					<tr>
						<td class="span3">ID</td>
						<td class="span9">${data.id}</td>
					</tr>
					<tr>
						<td class="span3">Client</td>
						<td class="span9">${data.clientName}</td>
					</tr>
					<tr>
						<td class="span3">sex</td>
						<td class="span9">${data.sex.description}</td>
					</tr>
					<tr>
						<td class="span3">Amount</td>
						<td class="span9"><spring:eval expression="data.amount" /></td>
					</tr>
					<tr>
						<td class="span3">CreateTime</td>
						<td class="span9"><spring:eval expression="data.createTime" /></td>
					</tr>
				</table>
				<a href="${pageContext.request.contextPath}/rest/orders/list/1"
					class="btn btn-info"> <i class="icon icon-arrow-left"></i> Back
					to Orders
				</a>
			</div>
			<!--/row-->
		</div>
		<!--/span-->
	</div>
	<!--/row-->
</body>
</html>
