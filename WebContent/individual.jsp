<%@page import="model.Lesson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    	"<name=\"id\" value=" + lesson.getId() + ">" +
    	"<input type=\"submit\" value=\"詳細へ\">" +
    	"</form>" +
    	"<br>" +
		"<form action=\"Board\" method=\"post\">" +
    	"<name=\"id\" value=" + lesson.getId() + ">" +
    	"<input type=\"submit\" value=\"掲示板へ\">" +
    	"</form>" +
    	"<br>");

%>

	<!-- <br>
	<input type="button" value="詳細へ">
	<br>
	<input type="button" value="掲示板へ">
	<br> -->
	<p>a</p>
	<img src='<%=request.getContextPath()%>/chart.png'>
</body>
</html>