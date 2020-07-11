<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Вход в систему</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
	<script src="../../resources/lib/jquery-ui-1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="../../resources/lib/jquery-ui-1.12.1/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
<div class="left">
    <a href="/" class="first">На главную</a>
</div>
	<div class="right">
		Назад
	</div>
	<div class="heading">
    <span class="index-header">
        Система управления студентов и их успеваемостью
    </span>
	</div>
	<form action="/login" method="post">
		<fieldset class="login-form">
			<legend>Вход в систему</legend>
			<div>
				<label for="login">Введите логин:</label>
				<input class="login-input" type="text" id="login" name="login" required autofocus>
			</div>
			<div>
				<label for="password">Введите пароль:</label>
				<input class="login-input" type="password" id="password" name="password">
			</div>
			<div>
				<label for="role">Выберите роль</label>
				<select id="role" name="role">
					<option value="student">Студент</option>
					<option value="admin">Администратор</option>
				</select>
			</div>
			<div>
				<input type="submit" value="Войти" class="buttonModify">
			</div>
		</fieldset>
	</form>
	<c:if test="${UserNotFound eq 1}">
		<span style="color: red">Пользователь не найден!!!</span>
	</c:if>
</div>
</body>
</html>
