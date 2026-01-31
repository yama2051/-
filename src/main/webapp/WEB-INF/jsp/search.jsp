<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[G001] 社員検索画面</title>
</head>
<body>
	<header>
		<h1>社員検索画面</h1>
	</header>
	
	<main>
		<section>
			<form action="search" method="post">
				<label>社員番号</label>
				<input type="text" name="employeeId">
				<label>氏名(姓)</label>
				<input type="text" name="lastName">
				<label>氏名（名）</label>
				<input type="text" name="firstName">
				<select name="departmentId">
					<option value="">選択してください。</option>
					<option value="営業部">営業部</option>
					<option value="経理部">経理部</option>
					<option value="総務部">総務部</option>
					<option value="法務部">法務部</option>
				</select>
				<label>在職区分</label>
				<input type="radio" value="1" name="status">在職
				<input type="radio" value="2" name="status">退職済
				<input type="radio" value="3" name="status">休職・育休
				<button type="subimit" name="action" value="search">検索</button>
				<button type="submit" name="action" value="regist" formacation="register">登録</button>
				<button type="submit" name="action" value="delete" formacation="delete">削除</button>
			</form>
		</section>
	</main>
	
</body>
</html>