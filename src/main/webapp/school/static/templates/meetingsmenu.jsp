<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Meetings Menu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/school/static/css/meetingsmenu.css">
</head>
<body>
<div class="center">
  <p>Hello ${sessionScope.loginName}</p>
</div>

<div class="center">
  <!-- Meetings Search -->
  <div class="search-wrapper">
    <div class="bot-gap">
      <span class="title">Meetings Search</span>
    </div>
    <div class="bot-gap">
      <form method="POST" action="${pageContext.request.contextPath}/schoolapp/searchMeeting">
        <input name="room" type="text" class="search rounded" placeholder="Insert meeting's Room" autofocus/>
        <br><br>
        <button class="search-btn rounded color-btn" type="submit">Search</button>
      </form>
    </div>
  </div>

  <!-- Meeting Insert -->
  <div class="insert-wrapper">
    <div class="bot-gap">
      <span class="title">Meetings Insert</span>
    </div>
    <div class="bot-gap">
      <form method="POST" action="${pageContext.request.contextPath}/schoolapp/insertMeeting">
        <label for="teacherSelect">Choose a Teacher:</label>
        <select name="teacherId" id="teacherSelect">
          <c:forEach var="teacher" items="${teachers}">
            <option value="${teacher.id}">${teacher.lastname}</option>
          </c:forEach>
        </select>
        <br>
        <label for="studentSelect">Choose a Student:</label>
        <select name="studentId" id="studentSelect">
          <c:forEach var="student" items="${students}">
            <option value="${student.id}">${student.lastname}</option>
          </c:forEach>
        </select>
        <br>
        <input name="room" type="text" value="${requestScope.insertedMeeting.room}" class="insert rounded" placeholder="Room: " autofocus/><br>
        <input name="meetingDate" type="text" value="${requestScope.insertedMeeting.meetingDate}" class="insert rounded" placeholder="Meeting Date: " autofocus/><br>
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
  <c:if test="${requestScope.meetingsNotFound}">
    <p>No meetings found !</p>
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
