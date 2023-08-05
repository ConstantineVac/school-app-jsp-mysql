<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/school/static/css/studentUpdate.css">
  <title>Update Student</title>
</head>
<body>

<h1 class="header">Updating Student: </h1>
<form action="${pageContext.request.contextPath}/schoolapp/updateStudent" method="post">

  <label for="studentID">Student ID</label>
  <input id="studentID" type="text" name="id" value="${param.id}" readonly><br>

  <label for="firstname">First Name:</label>
  <input type="text" id="firstname" name="firstname" value="${param.firstname}" required><br>

  <label for="lastname">Last Name:</label>
  <input type="text" id="lastname" name="lastname" value="${param.lastname}" required><br>

  <label for="gender">Gender:</label>
  <input type="text" id="gender" name="gender" value="${param.gender}" required><br>

  <label for="birthdate">Birthdate:</label>
  <input type="text" id="birthdate" name="birthdate" value="${param.birthdate}" required><br>

  <label for="cityId">City ID:</label>
  <input type="text" id="cityId" name="cityId" value="${param.cityId}" required><br>

  <input type="submit" value="Update">

  <c:if test="${requestScope.isError}">
    <p>${requestScope.message}</p>
  </c:if>
</form>
</body>
</html>
