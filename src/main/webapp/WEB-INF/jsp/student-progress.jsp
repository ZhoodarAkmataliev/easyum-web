<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Успеваемость студента</title>
	<link rel="stylesheet" href="../../resources/css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Lacquer&display=swap" rel="stylesheet">
</head>

<body>
<div class="container">
	<table>
		<tr>
			<th>Control system of students and their academic performance</th>
		</tr>
	</table>

	<button><a href="title_page.html">to main</a></button>
	<br>

	<button><a href="logout.html">logout</a></button>
	<br>


	<input type="button" onclick="history.back();" value="back"/>

	<h1>Displayed academic performance for follow student</h1>
	<br>


	<table>
		<thead class="thead1">
		<tr>
			<th>Last name</th>
			<th>First name</th>
			<th>Group</th>
			<th>Enrollment date</th>
		</tr>
		</thead>

		<thead>
		<tr>
			<td>${student.sername}</td>
			<td>${student.name}</td>
			<td>${student.group}</td>
			<td><f:formatDate value="${student.date}" pattern="dd/MM/yyyy"></f:formatDate></td>
		</tr>
		</thead>
	</table>
	<br>
	<br>

	<aside>
		<form action="http://echo.htmlacademy.ru" autocomplete="off" method="post" class="sp">
			Choose term

			<select>

				<option value="1">Term 1</option>
				<option value="1">Term 2</option>
				<option value="1">Term 3</option>
				<option value="1">Term 4</option>

			</select>

			<br>
			<br>
			Average assessment for term:
		</form>
	</aside>


	<section>
		<table>
			<caption>
				Disciplines list
			</caption>
			<thead class="thead1">
			<tr>
				<th>Discipline</th>
				<th class="th1">Assessment</th>

			</tr>
			</thead>

			<c:forEach items="${marks}" var="mark">
				<tr>
					<td>${mark.discipline.discipline}</td>
					<td>${mark.mark}</td>
				</tr>

			</c:forEach>
		</table>
	</section>
</div>
</body>
</html>