<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Inserted Successfully</title>
</head>
<body>
<h1>Student inserted successfully</h1>
<div>
  <p>First Name: ${requestScope.insertedStudent.firstname}</p>
  <p>Last Name: ${requestScope.insertedStudent.lastname}</p>
  <p>Gender: ${requestScope.insertedStudent.gender}</p>
  <p>Birthdate: ${requestScope.insertedStudent.birthdate}</p>
</div>

<div>
  <a href="${pageContext.request.contextPath}/school/static/templates/studentsmenu.jsp">Go Back</a>
</div>
</body>
</html>
