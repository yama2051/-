<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[G002]社員一覧</title>
</head>
<body>
	<header>
		<h1>社員一覧</h1>
	</header>
	
	<main>
		<section id="memberList">
		
			<form action="detail" method="post">
			<table border="3">
				<tr>
					<th>社員番号</th>
					<th>氏名</th>
					<th>部署名</th>
					<th>在職区分</th>
				</tr>
				
				<c:forEach var="emp" items="${employeeForm}" >
					<tr>
						<td>${emp.employeeId}</td>
						<td>${emp.lastName}${emp.firstName}</td>
						<td>${emp.departmentId}</td>
						<td>${emp.status}</td>
						<td><a href="detail?id=${emp.employeeId}">詳細</a>	</td>
					</tr>
				</c:forEach>
				
				
			</table>
	
				<button type="submit" formacation="delete">削除</button>	
			</form>
		
		</section>
	</main>
	
	<footer>
		<form action="register" method="post">
			<button type="submit" >登録</button>	
		</form>
	</footer>
</body>
</html>