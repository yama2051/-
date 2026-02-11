<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>[Gxxx]職員編集画面</title>
</head>
<body>
    <h1>職員編集画面</h1>
    
    <h3>基本情報</h3>
    
    <form action="update" method="post">
        
        <div>
            <label>社員番号（変更不可）</label>
            <input type="text" name="employeeId" value="${editForm.employeeId}" readonly style="background-color: #e9e9e9;">
        </div>

        <div>
            <label>姓</label>
            <input type="text" name="lastName" value="${editForm.lastName}">
        </div>

        <div>
            <label>名</label>
            <input type="text" name="firstName" value="${editForm.firstName}">
        </div>

        <div>
            <label>在職区分</label>
            <select name="status">
                <option value="0" ${editForm.status == '0' ? 'selected' : ''}>在職</option>
                <option value="1" ${editForm.status == '1' ? 'selected' : ''}>休職</option>
                <option value="2" ${editForm.status == '2' ? 'selected' : ''}>退職</option>
            </select>
        </div>
        
        <div>
        	<label>所属部署</label>
        	<input type="text" name="departmentId" value="${editForm.department}">
        </div>

        <h3>詳細情報</h3>
        <div>
            <label>メールアドレス</label>
            <input type="text" name="email" value="${editForm.email}">
        </div>

        <div>
            <label>備考</label>
            <textarea name="memo">${editForm.memo}</textarea>
        </div>

        <button type="submit">更新保存</button>
        <button type="button" onclick="history.back()">戻る</button>
    </form>
</body>
</html>