<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>City Update</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/school/static/css/cityUpdate.css">
</head>
<body>
    <div>
        <form method="POST" action="${pageContext.request.contextPath}/schoolapp/cityUpdate">
            <label for="cid">Κωδικός</label>
            <input id="cid" type="text" name="id" value="${param.id}" readonly><br>
            <label for="name">City Name</label>
            <input id="name" type="text" name="name" value="${param.name}"><br>

            <button type="submit">Update City</button>
        </form>
    </div>

    <c:if test="${requestScope.isError}">
        <p>${requestScope.message}</p>
    </c:if>
</body>
</html>
