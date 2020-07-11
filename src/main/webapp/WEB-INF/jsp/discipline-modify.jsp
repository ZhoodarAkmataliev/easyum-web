<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Изменение дисциплины</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<div class="container">
	<div>
		<a href="#" class="logout">Logout</a>
	</div>
	<div>
		<a href="#">На главную</a>
	</div>
	<div>
		<a href="#" class="back">Назад</a>
	</div>
	<div class="boxSite">
		<form action="/modify-discipline" method="post">
			<div class="box">Система управления студентами и их успеваемостью</div>
			<h2>Для того, чтобы модифицировать дисциплину, введите новое значение поля и нажмите кнопку "Создать"</h2>
			<p><label for="nameDiscipline">Название</label>
				<input type="text" id="nameDiscipline" name="secondName" placeholder="${discipline.discipline}" required
					   autofocus>
			</p>
			<input type="hidden" name="discID" value="${discipline.id}">
			<button class="buttonModify">Применить</button>
		</form>

	</div>
</div>
</body>
</html>