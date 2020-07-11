<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Создание студента</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
	<script src="../../resources/lib/jquery-ui-1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="../../resources/lib/jquery-ui-1.12.1/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
        $(function () {
            $("#datepicker").datepicker();
        });
	</script>
</head>
<body>
<div class="container">
	<div>
		<a href="#" class="logout">Logout</a>
	</div>
	<div>
		<a href="/index.jsp" class="first">На главную</a>
	</div>
	<div>
		<a href="javascript:history.back()" title="Вернуться на предыдущую страницу" class="back">Назад</a>
	</div>
	<div class="boxSite">
		<div class="box">Система управления студентами и их успеваемостью</div>
		<h2>Для создания студента заполните все поля и нажмите кнопку "Создать"</h2>
		<p><label for="secondName">Фамилия</label>
			<form action="/create-students" method="post">
				<input type="text" id="secondName" name="surname" placeholder="Введите фамилию" required autofocus>
		<p><label for="name">Имя</label>
			<input type="text" id="name" name="name" placeholder="Введите имя" required></p>
		<p><label for="group">Группа</label>
			<input type="text" id="group" name="group" required></p>
		<p><label for="datepicker">Дата поступления</label>
			<input type="text" id="datepicker" name="date" required></p>

		<input type="submit" value="Создать" class="buttonModify">
		</form>
	</div>
</div>
</body>
</html>
