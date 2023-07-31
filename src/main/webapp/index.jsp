<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="<c:url value="/school/static/css/index.css" />">
    <script src="<c:url value="/school/static/js/index.js" />"></script>
    <title>School App Pro</title>
</head>
<body>
<div class="container">
    <header class="header">
        <div class="logo">
            <img src="<c:url value="/school/static/img/grey_logo_aueb.png" />" alt="image">
        </div>
        <!-- Menu -->
        <nav class="navbar">
            <input class="side-menu" type="checkbox" id="side-menu">
            <label class="hamb" for="side-menu">
                <span class="hamb-line"></span>
            </label>
            <div class="navbar-links">
                <ul>
                    <li class="dropdown"><a href="javascript:void(0)">Home &#9662</a>
                        <ul class="dropdown-content">
                            <li><a href="">Education</a></li>
                            <li><a href="">Research</a></li>
                            <li><a href="">Services</a></li>
                            <li><a href="">Network</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="javascript:void(0)">We Educate &#9662</a>
                        <ul class="dropdown-content">
                            <li><a href="">Students</a></li>
                            <li><a href="">Professors</a></li>
                            <li><a href="">Staff</a></li>
                            <li><a href="">Facilities</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="javascript:void(0)">We Innovate &#9662</a>
                        <ul class="dropdown-content">
                            <li><a href="">Studies</a></li>
                            <li><a href="">Innovations</a></li>
                            <li><a href="">Partnerships</a></li>
                            <li><a href="">Sponsors</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="javascript:void(0)">We Are &#9662</a>
                        <ul class="dropdown-content">
                            <li><a href="">Location</a></li>
                            <li><a href="">History</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- Login icon -->
        <div class="login-icon">
            <a id="login" href="/login">
                <i class="fas fa-user"></i>
                <br>
                Login
            </a>
            <span></span>
        </div>
    </header>
</div>

<div class="main-body">
    <img src="<c:url value="/school/static/img/image.png" />" alt="image">
    <div class="tag"><span>Unlock your true potential...</span></div>
    <div class="tag2"><span>Become a full-stack Developer!</span></div>
</div>

<div class="main">
    <h2 class="main-title">Why Web Development Course</h2>
    <p class="main-par">Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque doloremque molestias ipsam commodi,
        consectetur voluptatum officiis reiciendis nemo animi quae fuga vitae laudantium tempore maxime illum rerum placeat quibusdam perferendis! Lorem,
        ipsum dolor sit amet consectetur adipisicing elit. Praesentium aperiam quasi repellat voluptatum aspernatur molestiae expedita unde officiis vero voluptate
        neque consequatur cum consectetur assumenda accusamus dolor consequuntur, odit ea.
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque doloremque molestias ipsam commodi,
        consectetur voluptatum officiis reiciendis nemo animi quae fuga vitae laudantium tempore maxime illum rerum placeat quibusdam perferendis! Lorem,
        ipsum dolor sit amet consectetur adipisicing elit. Praesentium aperiam quasi repellat voluptatum aspernatur molestiae expedita unde officiis vero voluptate
        neque consequatur cum consectetur assumenda accusamus dolor consequuntur, odit ea.
    </p>
    <br>
    <p class="main-par">Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque doloremque molestias ipsam commodi,
        consectetur voluptatum officiis reiciendis nemo animi quae fuga vitae laudantium tempore maxime illum rerum placeat quibusdam perferendis! Lorem,
        ipsum dolor sit amet consectetur adipisicing elit. Praesentium aperiam quasi repellat voluptatum aspernatur molestiae expedita unde officiis vero voluptate
        neque consequatur cum consectetur assumenda accusamus dolor consequuntur, odit ea.
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque doloremque molestias ipsam commodi,
        consectetur voluptatum officiis reiciendis nemo animi quae fuga vitae laudantium tempore maxime illum rerum placeat quibusdam perferendis! Lorem,
        ipsum dolor sit amet consectetur adipisicing elit. Praesentium aperiam quasi repellat voluptatum aspernatur molestiae expedita unde officiis vero voluptate
        neque consequatur cum consectetur assumenda accusamus dolor consequuntur, odit ea.
    </p>
    <br>
    <p class="main-par">Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque doloremque molestias ipsam commodi,
        consectetur voluptatum officiis reiciendis nemo animi quae fuga vitae laudantium tempore maxime illum rerum placeat quibusdam perferendis! Lorem,
        ipsum dolor sit amet consectetur adipisicing elit. Praesentium aperiam quasi repellat voluptatum aspernatur molestiae expedita unde officiis vero voluptate
        neque consequatur cum consectetur assumenda accusamus dolor consequuntur, odit ea.
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque doloremque molestias ipsam commodi,
        consectetur voluptatum officiis reiciendis nemo animi quae fuga vitae laudantium tempore maxime illum rerum placeat quibusdam perferendis! Lorem,
        ipsum dolor sit amet consectetur adipisicing elit. Praesentium aperiam quasi repellat voluptatum aspernatur molestiae expedita unde officiis vero voluptate
        neque consequatur cum consectetur assumenda accusamus dolor consequuntur, odit ea.
    </p>
</div>

<div class="footer">
    <p class="copyright">&copy; Web Development Course, AUEB - All rights reserved, 2023</p>
    <div class="social-links">
        <span class="flw">Follow us:</span>
        <a href="#"><i class="fab fa-facebook"></i></a>
        <a href="#"><i class="fab fa-twitter-square"></i></a>
    </div>
</div>
</body>
</html>
