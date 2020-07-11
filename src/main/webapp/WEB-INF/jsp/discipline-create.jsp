<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Создание дисциплины</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<div class="container">
	<div>
		<a href="#">Logout</a>
	</div>
	<div>
		<a href="#" class="first">На главную</a>
	</div>
	<div>
		<a href="#" class="back">Назад</a>
	</div>
	<div>
		<div>Система управления студентами и их успеваемостью</div>
		<h2>Для того, чтобы создать новую дисциплину, заполните все поля и нажмите кнопку "Создать"</h2>
		<p><label for="nameDiscipline">Название</label>
		<form action="/discipline-create" method="post">
			<input type="text" id="nameDiscipline" name="secondName" placeholder="Введите дисциплину" required
				   autofocus>
			<input type="submit" value="Создать">
		</form>
		</p>
	</div>
</div>
</body>
</html>
