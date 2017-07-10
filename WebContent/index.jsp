<%@page import="model.Lesson"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Logout" method="get">
	<input type="submit" value="ログアウト">
	</form>
	<br>
	<%-- 授業ボックステンプレ --%>
	<%
    ServletContext ctx = getServletContext();
	ArrayList<Lesson> lessonList = (ArrayList<Lesson>) ctx.getAttribute("lessonList");

	if(lessonList == null){
		return;
	}

    for(int i = 0; i < lessonList.size(); i++){
    	out.print("<b>" + lessonList.get(i).getName() + "</b>" +
    	"<form action=\"Lesson\" method=\"post\">" +
    	"<name=\"id\" value=" + lessonList.get(i).getId() + ">" +
    	"<input type=\"submit\" value=\"個別ページへ\">" +
    	"</form>" +
    	"<br>");
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