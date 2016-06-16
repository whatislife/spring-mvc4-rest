<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/views/common/meta.jsp"%>
<title>New Order</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">

				<div class="page-header">
					<h1>New Order</h1>
				</div>

				<form:form modelAttribute="data" method="post"
					action="${pageContext.request.contextPath}/rest/orders/save"
					cssClass="form-horizontal" theme="simple">
					<div class="control-group">
						<label class="control-label" for="clientName">Client</label>
						<div class="controls">
							<form:input path="clientName" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="amount">Amount</label>
						<div class="controls">
							<form:input path="amount" />
						</div>
					</div>
					<div class="form-actions">
						<input type="submit" value="submit" class="btn btn-primary" />
					</div>
				</form:form>
				<a href="${pageContext.request.contextPath}/rest/orders/list/1"
					class="btn btn-info"> <i class="icon icon-arrow-left"></i> Back
					to Orders
				</a>
			</div>
		</div>
	</div>
</body>
</html>
