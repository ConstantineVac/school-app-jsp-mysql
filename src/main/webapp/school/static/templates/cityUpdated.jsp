<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>City Updated</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/school/static/css/cityUpdated.css">
</head>
<body>
    <h1>New City Details: </h1>
    <p>city ${requestScope.city.name}</p>
    <a href="${pageContext.request.contextPath}/school/static/templates/citiesmenu.jsp">Go Back</a>
    <br>
    <p>${requestScope.message}</p>
</body>
</html>
