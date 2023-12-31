<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/school/static/css/teacherupdate.css">
	<title>Teacher Update</title>
</head>
<body>
	<div>
		<form method="POST" action="${pageContext.request.contextPath}/schoolapp/update">
			<label for="tid">ID</label>
			<input id="tid" type="text" name="id" value="${param.id}" readonly><br>
			<label for="firstname">Firstname</label>
			<input id="firstname" type="text" name="firstname" value="${param.firstname}"><br>
			<label for="lastname">Lastname</label>
			<input id="lastname" type="text" name="lastname" value="${param.lastname}"><br>
			<label for="specialtyId">Specialty ID</label>
			<input id="specialtyId" type="text" name="specialtyId" value="${param.specialtyId}"><br><br>
			<button type="submit">Update Teacher</button>
		</form>	
	</div>	

	<c:if test="${requestScope.isError}">
		<p>${requestScope.message}</p>
	</c:if>
</body>
</html>
