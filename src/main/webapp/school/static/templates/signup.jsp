<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/school/static/css/login.css">
</head>
<body>
<div class="container-fluid">
    <div class="container">
        <div class="row">
            <h1 class="text-grey">Sign Up</h1>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/signup">
            <div class="row">
                <input type="email" name="username" required placeholder="E-mail">
                <span></span>
            </div>
            <div class="row">
                <input type="password" name="password" required placeholder="Password">
                <span></span>
            </div>
            <div class="row">
                <button type="submit">Create Account</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
