<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<div>
		<form action="Login" method="post">
			<b> 学籍番号</b>
			<br>
			<input type="text" name="userID" size="30"maxlength="7">
			<br>
			<b> パスワード</b>
			<br>
			<input type="password" name="password" size="30" maxlength="20">
			<br>
			<%
    			ServletContext ctx = getServletContext();

				if(ctx.getAttribute("loginFailed") != null){
					boolean loginFailed = (boolean)ctx.getAttribute("loginFailed");

					if(loginFailed){
						out.println("<a>IDかパスワードが不正です</a>");
					}
				}
			%>

			<br>
			<input type="submit" value="ログイン">
		</form>
	</div>
</body>
</html>