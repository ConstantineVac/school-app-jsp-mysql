<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/school/static/css/teacherUpdated.css">
<title>Teacher Updated Successfully</title>
</head>
<body>
	<h1>Information Updated</h1>
	<p>Firstname:  ${requestScope.teacher.firstname}</p>
	<p>Lastname:  ${requestScope.teacher.lastname}</p>
	<p>Specialty ID: ${requestScope.teacher.specialtyId}</p>
	<br>
	<p>${requestScope.message}</p>
	<br>
	<div class="container"> <!-- Add the container -->
		<a href="${pageContext.request.contextPath}/school/static/templates/teachersmenu.jsp">Return</a>
	</div>
</body>
</html>
