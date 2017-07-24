<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="confirm.css">
</head>
<body>
	<br>
	<p>
	評価内容
	<input type="radio" name="review" value="1" disabled checked>1
	<input type="radio" name="review" value="2" disabled>2
	<input type="radio" name="review" value="3" disabled>3
	<input type="radio" name="review" value="4" disabled>4
	<input type="radio" name="review" value="5" disabled>5
	</p>
	<br>
	<textarea id="comment" name="comment" rows="4" cols="100"maxlength="400" readonly>こ↑こ↓に入力</textarea>
	<br>
	<button class="submit" type="submit">投稿する</button>
	<button class="cancel" type="button">取り消し</button>
</body>
</html>