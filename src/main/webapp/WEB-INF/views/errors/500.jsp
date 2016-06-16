<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>师傅，有妖怪:500</title>
</head>
<body>
	<%
		Exception e = (Exception) request.getAttribute("ex");
		
	%>
	<H2>
		未知错误:
		<%=e.getClass().getSimpleName()%>
		<%=e.getStackTrace() %>
		</H2>
	<hr />
	<P>错误描述：</P>
	<%=e.getMessage()%>
	<P>错误信息：</P>
	<%
		e.printStackTrace(new java.io.PrintWriter(out));
	%>
</body>
</html>