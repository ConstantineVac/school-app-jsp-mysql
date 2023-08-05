<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Teacher Inserted Successfully</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/school/static/css/teacherInserted.css">
</head>
<body>
	<h1>Teacher inserted successfully</h1>
	<div>
		<p>Teacher ID: ${requestScope.insertedTeacher.id}</p>
		<p>Teacher's Lastname: ${requestScope.insertedTeacher.lastname}</p>
		<p>Teacher's Firstname: ${requestScope.insertedTeacher.firstname}</p>
		<p>Teacher's Specialty ID: ${requestScope.insertedTeacher.specialtyId}</p>
		<p></p>
	</div>	
	 	
	<div>
		<a href="${pageContext.request.contextPath}/school/static/templates/teachersmenu.jsp">Return to Control Panel</a>
	</div> 	
</body>
</html>