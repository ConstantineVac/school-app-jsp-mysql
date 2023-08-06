<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Teacher Deleted Successfully</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/school/static/css/teacherDeleted.css">
</head>
<body>
	<p>Teacher: ${requestScope.teacherDTO.id} ${requestScope.teacherDTO.firstname} ${requestScope.teacherDTO.lastname} ${requestScope.teacherDTO.specialtyId}
		was deleted</p>
	<a href="${pageContext.request.contextPath}/schoolapp/teacherInsert">Go Back</a>
</body>
</html>
