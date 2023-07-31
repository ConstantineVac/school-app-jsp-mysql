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
	<h1>Νέα Στοιχεία Teacher</h1>
	<p>teacher ${requestScope.teacher.firstname}</p>
	<p>teacher ${requestScope.teacher.lastname}</p>
	<a href="${pageContext.request.contextPath}/school/static/templates/teachersmenu.jsp">Επιστροφή</a>
	<br>
	<p>${requestScope.message}</p>
</body>
</html>
