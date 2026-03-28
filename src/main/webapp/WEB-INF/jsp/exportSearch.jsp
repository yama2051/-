<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/commonForm.css">
<title>CSV出力用検索</title>
</head>
<body>
    <header>
        <h1>CSV 出力用検索</h1>
    </header>

    <main class="container">
        <form action="${pageContext.request.contextPath}/exportCsv" method="get">
            <div class="row">
                <div class="col">
                    <label>社員番号</label>
                    <input type="text" name="employeeId">
                </div>
                <div class="col">
                    <label>姓</label>
                    <input type="text" name="lastName">
                </div>
                <div class="col">
                    <label>名</label>
                    <input type="text" name="firstName">
                </div>
            </div>

            <div class="row" style="margin-top:12px;">
                <div class="col">
                    <label>所属</label>
                    <select name="departmentId">
                        <option value="">-- 指定しない --</option>
                        <option value="D01">開発部</option>
                        <option value="D02">営業部</option>
                        <option value="D03">人事部</option>
                        <option value="D04">総務部</option>
                        <option value="D05">経理部</option>
                        <option value="D11">企画部</option>
                    </select>
                </div>
                <div class="col">
                    <label>メール</label>
                    <input type="text" name="email">
                </div>
                <div class="col">
                    <label>在職区分</label>
                    <select name="status">
                        <option value="">-- 指定しない --</option>
                        <option value="0">在職</option>
                        <option value="1">休職</option>
                        <option value="2">退職</option>
                    </select>
                </div>
            </div>

            <div style="margin-top:18px;" class="button-group">
                <button type="submit" class="btn btn-edit">条件でCSV出力</button>
                <button type="button" class="btn btn-back" onclick="history.back()">戻る</button>
            </div>
        </form>
    </main>
</body>
</html>