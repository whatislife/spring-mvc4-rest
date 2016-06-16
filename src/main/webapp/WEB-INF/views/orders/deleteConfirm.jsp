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
					<h1>Delete Order ${id}</h1>
				</div>

				<form action="${pageContext.request.contextPath}/rest/orders/delete/${id}" method="post">
					<p>Are you sure you want to delete order ${id}?</p>
					<div class="btn-group">
						<input type="submit" value="Delete" class="btn btn-danger" /> <input
							type="button" value="Cancel" class="btn btn-success"
							onclick="window.location.href = '${pageContext.request.contextPath}/rest/orders/list/1'" />
					</div>
				</form>
				<br /> <a href="${pageContext.request.contextPath}/rest/orders/list/1"
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
