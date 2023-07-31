<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/school/static/css/login.css">
</head>
<body>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <h1 class="text-grey">Login</h1>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/login">
            <div class="row">
                <input type="email" name="username" required placeholder="E-mail">
                <span></span>
            </div>
            <div class="row">
                <input type="password" name="password" required placeholder="Password">
                <span></span>
            </div>
            <div class="row">
                <button type="submit">Sign In</button>
            </div>
        </form>
        <div class="row text-grey">
            <a href="#">Lost your password?</a>
        </div>
    </div>
    <div class="row">
        <p>Don't have an account? <a href="${pageContext.request.contextPath}/signup">Sign up here!</a></p>
    </div>
</div>

<div class="container">
    <c:if test="${requestScope.isError eq 'true'}">
        <p style="color: red">Login Error</p>
        <c:if test="${requestScope.isRegistered eq 'false'}">
            <p style="color: red">Username not found. You can <a href="${pageContext.request.contextPath}/signup">sign up here!</a>.</p>
        </c:if>
    </c:if>
    <c:if test="${requestScope.isRegistered eq 'true'}">
        <p style="color: green">Registration Successful. You can now login.</p>
    </c:if>
</div></div>
</body>
</html>
