<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE  html>
<html>
<head>
<meta charset="utf-8">
<title>Magazine</title>
<style type="text/css">
.page {
	width:100%;
	margin-left: auto;
	margin-right: auto;
}

.page::after {
	content: '';
	display: block;
	clear: both;
	height: 0;
}
img {
	display: inline-block;
	padding: 5px 5px 5px 5px;
}

.main{
	margin-left:15px;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="page">
		<div class="main">
		<img alt="image" src="new-york.jpg"> <img alt="image"
			src="city.jpg"> <img alt="image" src="new-york.jpg"> <img
			alt="image" src="city.jpg"> <img alt="image" src="dublin.jpg">
		<img alt="image" src="new-york.jpg">
		</div>

	<table class="table">
		<!-- HTML mycomment -->
		<!-- JSP mycomment -->
		<tr>
			<td data-th="login"></td>
		</tr>
	</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>