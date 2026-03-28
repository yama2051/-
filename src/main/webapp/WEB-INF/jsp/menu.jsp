<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/commonForm.css">
<title>[GM000]menue</title>
</head>
<body>
    <header>
        <h1>メニュー</h1>
    </header>

    <main class="container">
        <div style="display:flex;gap:12px;flex-wrap:wrap;">
            <form action="${pageContext.request.contextPath}/searchPage" method="get" style="margin:0">
                <button type="submit" class="btn btn-edit">社員検索</button>
            </form>

            <form action="${pageContext.request.contextPath}/exportSearch" method="get" style="margin:0">
                <button type="submit" class="btn">CSV出力用検索</button>
            </form>

            <form action="${pageContext.request.contextPath}/init" method="get" style="margin:0">
                <button type="submit" class="btn btn-back">ログアウト</button>
            </form>
        </div>

        <section style="margin-top:18px;">
            <h2>使い方</h2>
            <p>・「社員検索」を押すと検索画面に移動します。検索条件を入力して検索してください。<br>
               ・「CSV出力用検索」は条件を入力して、その条件に一致する社員を CSV で出力できます。</p>
        </section>
    </main>

</body>
</html>