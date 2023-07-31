<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Updated Successfully</title>
</head>
<body>
<h1>Student updated successfully</h1>
<div>
  <p>ID: ${requestScope.updatedStudent.id}</p>
  <p>First Name: ${requestScope.updatedStudent.firstname}</p>
  <p>Last Name: ${requestScope.updatedStudent.lastname}</p>
  <p>Gender: ${requestScope.updatedStudent.gender}</p>
  <p>Birthdate: ${requestScope.updatedStudent.birthdate}</p>
</div>

<div>
  <a href="${pageContext.request.contextPath}/school/static/templates/studentsmenu.jsp">Go Back</a>
</div>
</body>
</html>
