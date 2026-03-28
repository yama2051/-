<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/commonForm.css">
<title>G004 登録成功</title>
</head>
<body>
	<header>
		<h1>登録完了！</h1>
	</header>
	
	<main>
		<h2>登録完了しました。</h2>
	</main>
	
	<footer>
		<h2>
			<form action="${pageContext.request.contextPath}/menu" method="get" style="display:inline-block;">
				<button type="submit" class="btn btn-back">メニューへ戻る</button>
			</form>
		</h2>
	</footer>


</body>
</html>