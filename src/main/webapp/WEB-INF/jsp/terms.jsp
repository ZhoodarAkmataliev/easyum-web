<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Дисциплины</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
<div class="container">
		<span class="left">
    <a href="/" class="first">На главную</a>
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


	<div>
		<div class="heading">
        <span class="index-header">
            Система управления студентов и их успеваемостью
        </span>
		</div>
		<div>

			<div class="turn-term">
				<form action="/terms" method="get" id="choiceSemForm">
					<b>Выбрать семестр</b>
					<select class="select-term" name="selectedTermId">
						<c:forEach items="${semestrs}" var="sem">
							<c:choose>
								<c:when test="${sem.id eq selectedTerm.id}">
									<option value="${sem.id}" selected>${sem.semestr}</option>
								</c:when>
								<c:otherwise>
									<option value="${sem.id}">${sem.semestr}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>

					<input type="submit" value="Выбрать">
				</form>
			</div>

			<div class="how-long-term">
				Длительность семестра: ${selectedTerm.duration}
			</div>
			<div class="discipline-term-list">
				Список дисциплин семестра
			</div>
			<table class="terms-table">
				<tr>
					<td class="discipline-name" style="width: 500px">
						<b>Наименование дисциплины</b>
					</td>
				</tr>
				<c:forEach items="${disciplinesByTerm}" var="ds">
					<tr>
						<td style="width: 500px">
								${ds.discipline}
						</td>
					</tr>
				</c:forEach>
			</table>
			<form action="/create-semestr" method="get">
				<input type="submit" value="Создать семестр">
			</form>
			<form action="/modify-semestr" method="get">
				<input type="submit" value="Модифицировать семестр">
				<input type="hidden" name="idModifSem" id="idModifSem">
			</form>
			<form action="/delete-semestr" method="get" id="deleteSemForm">
				<input type="submit" value="Удалить семестр">

				<input type="hidden" name="isDeleteSem" id="isDeleteSem">
			</form>
		</div>
	</div>
</div>
</div>
</div>
</body>
</html>
