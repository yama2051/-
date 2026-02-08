<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>職員登録画面</title>
<style>
    .form-group { margin-bottom: 15px; }
    label { display: inline-block; width: 150px; font-weight: bold; }
    input[type="text"], input[type="email"], input[type="date"], select, textarea {
        width: 300px;
        padding: 5px;
    }
    h2 { border-left: 5px solid #333; padding-left: 10px; margin-top: 30px; }
    .button-group { margin-top: 20px; }
</style>
</head>
<body>
    <header>
        <h1>職員登録画面</h1>
    </header>

    <main>
        <form action="registFinish" method="post" accept-charset="UTF-8">
            
            <h2>基本情報</h2>
            <div class="form-group">
                <label>社員番号</label>
                <input type="text" name="employeeId" required placeholder="例: 1001">
            </div>

            <div class="form-group">
                <label>姓</label>
                <input type="text" name="lastName" required placeholder="例: 山田">
            </div>

            <div class="form-group">
                <label>名</label>
                <input type="text" name="firstName" required placeholder="例: 太郎">
            </div>

            <div class="form-group">
                <label>部署ID</label>
                <input type="text" name="departmentId" placeholder="例: D01">
            </div>

            <div class="form-group">
                <label>在職区分</label>
                <select name="status">
                    <option value="0">在職</option>
                    <option value="1">休職</option>
                    <option value="2">退職</option>
                </select>
            </div>

            <h2>詳細情報</h2>
            <div class="form-group">
                <label>メールアドレス</label>
                <input type="email" name="email" placeholder="example@mail.com">
            </div>

            <div class="form-group">
                <label>内線番号</label>
                <input type="text" name="extensionNumber" placeholder="例: 123-456">
            </div>

            <div class="form-group">
                <label>入社年月</label>
                <input type="date" name="hireDate">
            </div>

            <div class="form-group">
                <label>備考</label><br>
                <textarea name="memo" rows="4" cols="50" placeholder="特別な事情がある場合のみ記載"></textarea>
            </div>

            <div class="button-group">
                <button type="button" onclick="history.back()">戻る</button>
                <button type="submit">登録を実行する</button>
            </div>
        </form>
    </main>
</body>
</html>