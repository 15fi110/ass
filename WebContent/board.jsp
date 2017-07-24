<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
	<button class = "Lbutton" type="button" >授業一覧へ</button>
	<button class = "Rbutton" type="button" >個別ページへ</button>
	<br>
	<div class = "comment">
	<b>学籍番号</b> 投稿内容
	<br>
	</div>
	<input type="checkbox">教員の閲覧を許可する
	<br>
	<textarea id="comment" name="comment" rows="4" cols="40"
		maxlength="140" placeholder="こ↑こ↓に入力"></textarea>
	<br>
	<input type="submit" value="投稿">
</body>
</html>