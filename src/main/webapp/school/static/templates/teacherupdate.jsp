<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Update</title>
</head>
<body>
	<div>
		<form method="POST" action="${pageContext.request.contextPath}/schoolapp/update">
			<label for="tid">Κωδικός</label>
			<input id="tid" type="text" name="id" value="${param.id}" readonly><br>
			<label for="firstname">Όνομα</label>
			<input id="firstname" type="text" name="firstname" value="${param.firstname}"><br>
			<label for="lastname">Επώνυμο</label>
			<input id="lastname" type="text" name="lastname" value="${param.lastname}"><br><br>
			<button type="submit">Update Teacher</button>
		</form>	
	</div>	

	<c:if test="${requestScope.isError}">
		<p>${requestScope.message}</p>
	</c:if>
</body>
</html>
