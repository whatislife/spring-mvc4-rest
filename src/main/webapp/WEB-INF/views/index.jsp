<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>spring-mvc4-rest</title>
<%@ include file="/WEB-INF/views/common/meta.jsp"%>
<style type="text/css">
li {
	line-height: 150%;
	font-size: 18px;
	
}

a {
	text-decoration: none
}

a:hover {
	text-decoration: under-line;
	color:red;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<ul>	
		<li><a href="${pageContext.request.contextPath}/rest/orders/list/1" target="_blank">rest/orders/list/1</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders/list/1.xml" target="_blank">rest/orders/list/1.xml</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders/list/1.json" target="_blank">rest/orders/list/1.json</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/rest/orders/writeXml" target="_blank">rest/orders/writeXml</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders/writeJson" target="_blank">rest/orders/writeJson</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders/writeHtml" target="_blank">rest/orders/writeHtml</a></li>
		<li><a href="${pageContext.request.contextPath}/rest/orders/writeImage" target="_blank">rest/orders/writeImage</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="#" onclick="getModel()">ajax/get-model-json</a></li>
		<li><a href="#" onclick="postModel()">ajax/post-model-json</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="#" onclick="getModelXml()">ajax/get-model-xml</a></li>
		<li><a href="#" onclick="postModelXml()">ajax/post-model-xml</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/common-exception"  target="_blank">exception/common-exception</a></li>
		<li><a href="${pageContext.request.contextPath}/biz-exception"  target="_blank">exception/biz-exception</a></li>	
		<li style="list-style:none">&nbsp;</li>
		<li><a href="#" onclick="showCommonException()">exception/ajax-common-exception</a></li>
		<li><a href="#" onclick="showBizException()">exception/ajax-biz-exception</a></li>
		<li style="list-style:none">&nbsp;</li>
		<li><a href="#" onclick="showEdit()">ajax/edit</a></li>
	</ul>
	<script type="text/javascript">
	
		function showEdit(){	
			
			var d = dialog({
    			title: '请输入orderId:',
			    content: '<input id="orderId" value="" />',
			    ok: function () {
			        var value = $('#orderId').val();
			        if (value==""){
			        	alert("orderId不能为空!");
			        	$('#orderId').focus();
			        	return false;
			        }
			        this.close(value);
			        this.remove();
			    },
			    okValue: '确认'
			});		
			
			
			d.addEventListener('close', function () {
			
				var orderId = this.returnValue;
				
				if (orderId==null||orderId.length==0||orderId==undefined){
					return false;
				}
			
				var loadingWin = dialog({title:"loading...",width:100,cancel: false});
			
				$.ajax({
	                type:"GET",
	                url:"${pageContext.request.contextPath}/rest/orders/show/" + orderId, 
	                beforeSend:function(){	                	
						loadingWin.showModal();
	                },   
	                complete:function(){
	                	loadingWin.close();
	                },           
	                success: function(d, textStatus, jqXHR){
	                	if (d.error!=undefined){
	                		alert("错误：" + d.detail);
	                		return false;
	                	}	                	                
	                    var editWin = dialog({
			    			title: '详情',
						    content: d						    
						});
						editWin.showModal();
	                },
	                error: function(jqXHR, textStatus, errorThrown){
	                    alert('error: ' + textStatus);
	                }
	            });
    			
			});
			d.showModal();
			$("#orderId").focus();
		}
	
		function showCommonException(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/common-exception",               
                success: function(d, textStatus, jqXHR){
                	if (d.error!=undefined){
                		alert("错误：" + d.detail);
                		return false;
                	}
                	//其它正常处理
                    alert("ajax请求成功！");
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
        
        function showBizException(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/biz-exception",               
                success: function(d, textStatus, jqXHR){
                	if (d.error!=undefined){
                		alert("错误：" + d.detail);
                		return false;
                	}
                	//其它正常处理
                    alert("ajax请求成功！");
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
	function getModel(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/rest/orders/show/21.json",               
                success: function(d, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + d + "\n\nid:" + d.data.id +"\nclientName:" + d.data.clientName + "\namount:" + d.data.amount + "\ncreateTime:" + (new Date(d.data.createTime)).toLocaleDateString());
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
      function getModelXml(){           
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/rest/orders/show/21.xml",               
                success: function(data, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + data.documentElement.outerHTML );
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
        function postModel(){           
            $.ajax({              
                type:"POST",
                dataType: "json",
                contentType: 'application/json',
                data:JSON.stringify({"clientName":"Jim","amount":66,"createTime":1413947088717}),
                url:"${pageContext.request.contextPath}/rest/orders/save",               
                success: function(d, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + d + "\n\nid:" + d.data.id +"\nclientName:" + d.data.clientName + "\namount:" + d.data.amount + "\ncreateTime:" + (new Date(d.data.createTime)).toLocaleDateString());
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
        
       function postModelXml(){           
            $.ajax({              
                type:"POST",
                dataType: "xml",
                contentType: 'application/xml',
                data:"<order><amount>99</amount><clientName>Z</clientName><createTime>2014-10-24T13:33:54+08:00</createTime></order>",
                url:"${pageContext.request.contextPath}/rest/orders/save",               
                success: function(data, textStatus, jqXHR){
                    alert("以下是从服务器返回的对象:\n\n" + data.documentElement.outerHTML);
                },
                error: function(jqXHR, textStatus, errorThrown){
                    alert('error: ' + textStatus);
                }
            });           
        }
	</script>
</body>
</html>