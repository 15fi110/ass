<%@page import="model.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    ServletContext ctx = getServletContext();
	Lesson lesson = (Lesson) ctx.getAttribute("lesson");

	if(lesson == null){
		return;
	}

    out.print("<b>" + lesson.getName() + "</b>" +
	"<br> " + lesson.getDescription());

    out.print("<br>"  +
    	"<form action=\"Detail\" method=\"post\">" +
    	"<input type=\"hidden\" name=\"id\" value=" + lesson.getId() + ">" +
    	"<input type=\"submit\" value=\"詳細へ\">" +
    	"</form>" +
    	"<br>" +
		"<form action=\"Board\" method=\"post\">" +
    	"<input type=\"hidden\" name=\"id\" value=" + lesson.getId() + ">" +
    	"<input type=\"submit\" value=\"掲示板へ\">" +
    	"</form>" +
    	"<br>");

 // クッキーに格納する文字列を作成(URLエンコードをする)
  	String value = URLEncoder.encode(String.valueOf(lesson.getId()));

  // 名前が"accesstime"、値が現在時刻であるクッキーを作成
  Cookie cookie = new Cookie("lesson", value);

  // クッキーの設定
  cookie.setMaxAge(7 * 24 * 60 * 60); //有効期間を1週間に設定

  // クッキーを発行
  response.addCookie(cookie);

%>

	<!-- <br>
	<input type="button" value="詳細へ">
	<br>
	<input type="button" value="掲示板へ">
	<br> -->
</body>
</html>