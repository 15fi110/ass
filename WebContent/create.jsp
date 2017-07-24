<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="create.css">
</head>
<body>
	<input type="text" name="subjectName" size="30" placeholder="こ↑こ↓に入力">
	<br>
	<div class="subComment">
	<textarea id="subjectOutline" name="subjectOutline" rows="10" cols="100"
		maxlength="1000" placeholder="こ↑こ↓に入力"></textarea>
	</div>
	<br>
	<button class="submit" type="submit">確定</button>
	<button class="cancel" type="submit">戻る</button>
</body>
</html>