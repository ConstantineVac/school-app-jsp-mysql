<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Deleted Successfully</title>
</head>
<body>
<h1>Student deleted successfully</h1>

  <p>Student: ${requestScope.studentDTO.id} ${requestScope.studentDTO.firstname} ${requestScope.studentDTO.lastname}
        was deleted</p>
  <a href="${pageContext.request.contextPath}/school/static/templates/studentsmenu.jsp">Go Back</a>
</div>
</body>
</html>
