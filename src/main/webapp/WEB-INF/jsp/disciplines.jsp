<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="ru">

<head>
	<meta charset="UTF-8">
	<title>Дисциплины</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
	<script src="../../resources/js/functions.js"></script>
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
			<div>
				<div>
					<div class="disciplines-list"><b>Список дисциплин</b></div>
				</div>

				<c:forEach items="${disciplines}" var="d">
					<div class="table">
						<div class="table-row">
							<fieldset class="discipline-box">
								<input type="checkbox" id="disciplines" value="${d.id}">
								<label for="disciplines">${d.discipline}</label>

							</fieldset>
						</div>

					</div>
				</c:forEach>

			</div>
		</div>

		<div>
			<div>

				<form action="/discipline-create" method="get">
					<input type="submit" value="Создать дисциплину...">
				</form>

				<input type="submit" onclick="modifiingDiscipline()" value="Модифицировать дисциплину">
				<form action="/modify-discipline" id="modifDiscForm">
					<input type="hidden" name="idModifyDisc" id="idModifyDisc">
				</form>

				<input type="submit" onclick="deleteDiscipline()" value="Удалить выбранные дисциплины">
				<form action="/discipline-delete" id="deleteDiscForm">
					<input type="hidden" name="idsDeleteDisc" id="idsDeleteDisc">
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>