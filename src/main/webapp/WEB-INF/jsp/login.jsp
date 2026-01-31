<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[G000]LoginPage</title>
</head>
<body>
	<header>
		<h1>ログイン情報</h1>
	</header>
	
	<main>
	
		<form class="loginForm" action="login" method="post">
			<label>社員番号</label>
			<input type="text" name="employeeId">
			<label>パスワード</label>
			<input type="text" name="password">
			<button type="submit" id="loginButton">ログイン</button>
		</form>
		
	</main>
	
	<footer>
		
	</footer>

</body>
</html>