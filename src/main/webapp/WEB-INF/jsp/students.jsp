<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Список студентов</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
	<script src="../../resources/js/functions.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
<span class="left">
    <a href="../../index.jsp" class="first">На главную</a>
</span>
	<div class="login-logout right">
		<c:choose>
			<c:when test="${isLogin eq 1}">
				<a href="/logout">Logout</a>
			</c:when>
			<c:otherwise>
				<a href="/login">Login</a>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="center">
		align text
	</div>

	<div>
		<div class="heading">
        <span class="index-header">
            Система управления студентов и их успеваемостью
        </span>
		</div>
		<div>
			<div>
				<div class="students-list">Список студентов</div>
				<table>
					<tr>
						<td style="width: 80px" class="header-one"></td>
						<td style="width: 200px" class="header-two"><b>Фамилия</b></td>
						<td style="width: 200px" class="header-three"><b>Имя</b></td>
						<td style="width: 200px" class="header-four"><b>Группа</b></td>
						<td style="width: 150px" class="header-five"><b>Дата поступления</b></td>
					</tr>
					<c:forEach items="${students}" var="s">
						<tr>
							<td class="temp-one"><input class="td-input" type="checkbox" value="${s.id}"></td>
							<td class="temp-two">${s.sername}</td>
							<td class="temp-three">${s.name}</td>
							<td class="temp-four">${s.group}</td>
							<td class="temp-five">${s.date}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%--        <c:if test="${role eq 'admin'}">--%>
			<div class="change-forms">
				<form action="/student-progress" id="studentProgressForm">
					<input type="hidden" id="idStudentProgress" name="idStudentProgress">
				</form>
				<input class="student-progress-form" onclick="studentProgress()" type="submit"
					   value="Посмотреть успеваемость выбранного студента">
				<form action="#">
					<button>Модифицировать выбранного студента...</button>
				</form>
				<form action="#">
					<button>Удалить выбранных студентов</button>
				</form>
				<form action="/create-students">
					<button type="submit">Создать студента...</button>
				</form>
			</div>
			<%--    </c:if>--%>
		</div>
	</div>
</div>
</body>
</html>
