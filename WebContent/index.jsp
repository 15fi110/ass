
<%@page import="model.Lesson"%>
<%@page import="model.BaseUser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index-ghost.css">
</head>
<body>
	<b>授業一覧</b>
	<form action="Logout" method="get">
	<input type="submit" value="ログアウト">
	</form>
	<br>
	<%-- 授業ボックス --%>
	<%
    ServletContext ctx = getServletContext();
	ArrayList<Lesson> lessonList = (ArrayList<Lesson>) ctx.getAttribute("lessonList");

	if(lessonList == null){
		return;
	}
    for(int i = 0; i < lessonList.size(); i++){
    	out.print("<div>" + "<b>" + lessonList.get(i).getName() + "</b>" +
    	"<form action=\"Lesson\" method=\"post\">" +
    	"<input type=\"hidden\" name=\"id\" value=" + lessonList.get(i).getId() + ">" +
    	"<input type=\"submit\" value=\"個別ページへ\">" +
    	"</form>" +
    	"<br>" +
    	"</div>");
    }

    BaseUser user = (BaseUser) ctx.getAttribute("user");

 	// クッキーに格納する文字列を作成(URLエンコードをする)
 	String numberValue = URLEncoder.encode(user.getUserID());
 	String passwordValue = URLEncoder.encode(user.getPassword());

 // 名前が"accesstime"、値が現在時刻であるクッキーを作成
 Cookie numberCookie = new Cookie("number", numberValue);
 Cookie passwordCookie = new Cookie("password", passwordValue);

 // クッキーの設定
 numberCookie.setMaxAge(7 * 24 * 60 * 60); //有効期間を1週間に設定
 passwordCookie.setMaxAge(7 * 24 * 60 * 60); //有効期間を1週間に設定

 // クッキーを発行
 response.addCookie(numberCookie);
 response.addCookie(passwordCookie);
 %>
	<!-- <b>授業名</b>
	<form action="Lesson" method="post">
	<name="id" value=>
	<input type=submit value="個別ページへ">
	</form>
	<br> -->
</body>
</html>