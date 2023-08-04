<%@ page contentType="text/html;charset=UTF-8" %>
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
        <input name="teacherId" type="text" value="${requestScope.insertedMeeting.teacherId}" class="insert rounded" placeholder="Teacher's ID: " autofocus/><br>
        <input name="studentId" type="text" value="${requestScope.insertedMeeting.studentId}" class="insert rounded" placeholder="Student ID: " autofocus/><br>
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
    <p>No meetings found</p>
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
