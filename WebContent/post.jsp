<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="post.css">
</head>
<body>
	<button class="go" type="button">詳細へ</button>
	<br>
	<div class="subReview">
	<p>評価内容
	<input type="radio" name="review" value="1">1
	<input type="radio" name="review" value="2">2
	<input type="radio" name="review" value="3">3
	<input type="radio" name="review" value="4">4
	<input type="radio" name="review" value="5">5
	</p>
	</div>
	<br>
	<textarea id="comment" name="comment" maxlength="400" rows="4" cols="100"
		placeholder="こ↑こ↓に入力"></textarea>
	<br>
	<button class="submit" type="buttonn">投稿する</button>

</body>
</html>