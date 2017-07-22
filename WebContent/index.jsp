<%@page import="model.Lesson"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
	<div class = "title"><b>授業一覧</b></div>
	<form action="Logout" method="get">
	<input type="submit" value="ログアウト">
	</form>
	<%-- 授業ボックス --%>
	<%
    ServletContext ctx = getServletContext();
	ArrayList<Lesson> lessonList = (ArrayList<Lesson>) ctx.getAttribute("lessonList");

	if(lessonList == null){
		return;
	}
    for(int i = 0; i < lessonList.size(); i++){
    	out.print("<div class = \"box\">" + "<b>" + lessonList.get(i).getName() + "</b>" +
    	"<form action=\"Lesson\" method=\"post\">" +
    	"<input type=\"hidden\" name=\"id\" value=" + lessonList.get(i).getId() + ">" +
    	"<input type=\"submit\" value=\"個別ページへ\">" +
    	"</form>" +
    	"<br>" +
    	"</div>");
    }

%>

	<!-- <b>授業名</b>
	<form action="Lesson" method="post">
	<name="id" value=>
	<input type=submit value="個別ページへ">
	</form>
	<br> -->
</body>
</html>