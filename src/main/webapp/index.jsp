<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>Система управления студентами</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<div class="container">
	<div class="login-logout">
		<c:choose>
			<c:when test="${isLogin eq 1}">
				<a href="/logout">Logout</a>
			</c:when>
			<c:otherwise>
				<a href="/login">Login</a>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="heading">
    <span class="index-header">
        Система управления студентов и их успеваемостью
    </span>
	</div>

	<div class="section-div">
		<span class="sections"><a href="/disciplines">Дисциплины</a></span>
		<span class="sections"><a href="/students">Студенты</a></span>
		<span class="sections"><a href="/terms">Семестры</a></span>
	</div>
</div>
</body>
</html>
