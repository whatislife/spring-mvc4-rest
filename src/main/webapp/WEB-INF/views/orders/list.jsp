<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/views/common/meta.jsp"%>   
    <title>Orders</title> 
    <link href="${pageContext.request.contextPath}/resources/css/simplePagination/simplePagination.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/simplePagination/jquery.simplePagination.js"></script>	  
	<script type="text/javascript">				
		var pageIndex = ${pageIndex};
		var pageSize = ${pageSize};
		var totalPages = ${totalPages};
		var totalCounts = ${totalCounts};
		
		$(document).ready(function() {
		
			$("#page-box").pagination({
			        items: totalCounts,
			        itemsOnPage: pageSize,
			        currentPage:pageIndex,
			        cssStyle: 'light-theme',			        
			        prevText:'<',	
			        nextText:'>',	        
			        onPageClick:function(page){
						gotoPage(page);
					}
			});			
			showPageInfo();
			
		});
		
		function gotoPage(page) {
			window.location = "${pageContext.request.contextPath}/rest/orders/list/" + page;			
		}
		
		function showPageInfo(){
			$("#page-info").html(pageSize + "条/页，共" + totalCounts + "条，第" + pageIndex + "页，共" + totalPages + "页");
		}
	</script>  
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
	        <div class="page-header">
	            <h1>Orders:</h1>
		    </div>
            <s:actionmessage  cssClass="alert alert-error"/>
            <table class="table table-striped" border="1" cellpadding="3" cellspacing="5">
                <tr>
                    <th>ID</th>
                    <th>Client</th>
                    <th>Amount</th>
                    <th>Sex</th>
                    <th>CreateTime</th>                    
                    <th>Actions</th>
                </tr>
               <c:forEach var="c" items="${data.orders}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.clientName}</td>
                    <td><spring:eval expression="c.amount" /></td>
                    <td>${c.sex}/${c.sex.description}/${c.sex.value}</td>
                    <td><spring:eval expression="c.createTime" /></td>
                    <td>
                        <div class="btn-group">
                            <a href="${pageContext.request.contextPath}/rest/orders/show/${c.id}" class="btn"><i class="icon icon-eye-open"></i> View</a>
                            <a href="${pageContext.request.contextPath}/rest/orders/edit/${c.id}" class="btn"><i class="icon icon-edit"></i> Edit</a>
                            <a href="${pageContext.request.contextPath}/rest/orders/deleteConfirm/${c.id}" class="btn btn-danger"><i class="icon icon-trash"></i> Delete</a>
                        </div>
                   </td>
                </tr>
               </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}/rest/orders/create" class="btn btn-primary"><i class="icon icon-file"></i> Create a new order</a>
            <table style="width:100%;margin:0 auto">
						<tr>							
							<td>
								<div id="page-box"></div>
							</td>
							<td width="40%" style="text-align:right;vertical-align:middle" id="page-info">								
							</td>
						</tr>
					</table>
        </div>
    </div>
</div>
</body>
</html>
	