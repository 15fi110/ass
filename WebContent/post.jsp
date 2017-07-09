<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="詳細へ">
	<br>
	<textarea id="comment" name="comment" readonly>評価内容</textarea>
	<input type="radio" name="review" value="1">1
	<input type="radio" name="review" value="2">2
	<input type="radio" name="review" value="3">3
	<input type="radio" name="review" value="4">4
	<input type="radio" name="review" value="5">5
	<br>
	<textarea id="comment" name="comment" maxlength="400"
		placeholder="こ↑こ↓に入力"></textarea>
	<br>
	<input type="buttonn" value="投稿する">

</body>
</html>