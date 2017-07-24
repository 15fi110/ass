<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="adminIndex.css">
</head>
<body>
	<button class = "new" type="submit">新規作成</button>
	<button class = "logout" type="submit">ログアウト</button>
	<br>
	<%-- 授業ボックステンプレ --%>
	<div class = "box">
	<b>授業名</b>
	<input type="button" value="表示">
	<input type="button" value="非表示">
	<input type="button" value="削除">
	</div>
	<br>
</body>
</html>