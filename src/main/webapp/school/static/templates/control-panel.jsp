<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Control Panel</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
        crossorigin="anonymous" referrerpolicy="no-referrer">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/school/static/css/control-panel.css">
</head>
<body>
<div class="container">
  <h1>Welcome to the Control Panel</h1>
  <div class="buttons-container">
    <a href="${pageContext.request.contextPath}/school/static/templates/teachersmenu.jsp" class="control-btn">
      <i class="fas fa-chalkboard-teacher"></i>
      Teachers Menu
    </a>
    <a href="${pageContext.request.contextPath}/school/static/templates/studentsmenu.jsp" class="control-btn">
      <i class="fas fa-user-graduate"></i>
      Students Menu
    </a>
  </div>
</div>
</body>
</html>
