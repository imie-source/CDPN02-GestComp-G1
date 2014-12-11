<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-2-1-1.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js"></script>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<% String pageTitle = (String) request.getAttribute("pageTitle"); %>
<title><%= pageTitle %></title>
</head>
<body>
	<%
		String jsp = (String) request.getAttribute("jspName");
		String curPage = (String) session.getAttribute( "curPage" );
	%>
	<jsp:include page="modal-confirm.jsp"/>
	<jsp:include page="modal-alert.jsp"/>
	<div class="container">
		<jsp:include page="header.jsp"/>
		<jsp:include page="menu.jsp"/>
		<div id="<%= curPage %>" class="content">
			<jsp:include page="<%= jsp %>"/>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>