<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>職員詳細画面</title>
</head>
<body>
	<header>
		<h1>職員詳細画面</h1>
	</header>
	
	<main id="detailMain">

		<div id="baseMemberInfo">
			<h2>職員基本情報</h2>
				<h3>社員番号</h3>
					<div>${detailForm.employeeId }</div>
				<h3>氏名</h3>
					<div>${detailForm.lastName}${detailForm.firstName}</div>
				<h3>メールアドレス</h3>
					<div>${detailForm.email }</div>
				<h3>電話番号</h3>
					<div>${detailForm.extensionNumber }</div>
					
		</div>
		
		<div id="baseDepartmentInfo">
			<h2>所属情報</h2>
				<h3>部署名</h3>
					<div>${detailForm.department}</div>
				<h3>在職区分</h3>
					<div class="info-value">
                		<c:choose>
                   			 <c:when test="${detailForm.status == '0'}">在職</c:when>
                   			 <c:when test="${detailForm.status == '1'}">休職</c:when>
                    		<c:otherwise>退職</c:otherwise>
                		</c:choose>
            </div>
		</div>
		
		<div>
			<h2>履歴</h2>
				<h3>入社年月</h3>
					<div>${detailForm.hireDate }</div>
			
		</div>
		
		<div>
			<h2>備考</h2>
			<h3>※特別な事情がある場合のみ記載してください。</h3>
				<div>${detailForm.memo }</div>
		</div>

	</main>
	
	<footer>
		<div class="button-group">
        	<button type="button" class="btn btn-back" onclick="history.back()">戻る</button>
        	<form action="/employee/edit" method="get">
            	<input type="hidden" name="employeeId" value="${detailForm.employeeId}">
            	<button type="submit" class="btn btn-edit">編集する</button>
        	</form>
        	<form action="/employee/delete" method="post">
        		<input type="hidden" name="employeeId" value="${detailForm.employeeId}">
            	<button type="submit" class="btn btn-edit" onclick="return confirm('選択した社員を削除しますか？')">削除する</button>
        	</form>
    	</div>
	</footer>
	

</body>
</html>