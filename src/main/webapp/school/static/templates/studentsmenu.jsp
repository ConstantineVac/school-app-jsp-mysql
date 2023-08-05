<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Students Search and Insert</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/school/static/css/studentsmenu.css">
</head>
<body>
<div class="center">
  <p>Hello ${sessionScope.loginName}</p>
</div>

<div class="center">
  <!-- Students Search -->
  <div class="search-wrapper">
    <div class="bot-gap">
      <span class="title">Students Search</span>
    </div>
    <div class="bot-gap">
      <form method="POST" action="${pageContext.request.contextPath}/schoolapp/searchStudent">
        <input name="lastname" type="text" class="search rounded" placeholder="Insert student's lastname" autofocus/>
        <br><br>
        <button class="search-btn rounded color-btn" type="submit">Search</button>
      </form>
    </div>
  </div>

  <!-- Students Insert -->
  <div class="insert-wrapper">
    <div class="bot-gap">
      <span class="title">Students Insert</span>
    </div>
    <div class="bot-gap">
      <form method="POST" action="${pageContext.request.contextPath}/schoolapp/studentInsert">
        <input name="firstname" type="text" value="${requestScope.studentInserted.firstname}" class="insert rounded" placeholder="Firstname" autofocus/><br>
        <input name="lastname" type="text" value="${requestScope.studentInserted.lastname}" class="insert rounded" placeholder="Lastname" autofocus/><br>
        <input name="gender" type="text" value="${requestScope.studentInserted.gender}" class="insert rounded" placeholder="Gender" autofocus/><br>
        <input name="birthdate" type="text" value="${requestScope.studentInserted.birthdate}" class="insert rounded" placeholder="Birthdate" autofocus/><br>
        <input name="cityId" type="text" value="${requestScope.studentInserted.cityId}" class="insert rounded" placeholder="City ID" autofocus/><br>
        <br>
        <button class="search-btn rounded color-btn" type="submit">Insert</button>
      </form>
    </div>
  </div>
</div>

<div class="center">
  <c:if test="${requestScope.sqlError}">
    <p>${requestScope.message}</p>
  </c:if>
</div>
<div class="center">
  <c:if test="${requestScope.studentsNotFound}">
    <p>No students found !</p>
  </c:if>

  <p>${requestScope.error}</p>
</div>
<div class="center">
  <a href="${pageContext.request.contextPath}/school/static/templates/control-panel.jsp" class="back-btn">
    <i class="fas fa-arrow-left"></i> Back to Control Panel
  </a>
</div>
</body>
</html>
