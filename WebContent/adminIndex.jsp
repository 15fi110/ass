<%@page import="model.Lesson"%>
<%@page import="model.BaseUser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="adminIndex.css">
</head>
<body>
	<form class = "new" action="GoCreate" method="get">
	<input type="submit" value="新規作成">
	</form>
	<form class = "logout" action="Logout" method="get">
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
    	out.print("<div  class = \"box\">" + "<b>" + lessonList.get(i).getName() + "</b>" +
    	"<form action=\"Change\" method=\"post\">" +
    	"<input type=\"hidden\" name=\"id\" value=" + lessonList.get(i).getId() + ">" +
    	"<input type=\"hidden\" name=\"isShowing\" value=true>" +
    	"<input type=\"submit\" value=\"表示\">" +
    	"</form>" +
    	"<br>" +
    	"<form action=\"Change\" method=\"post\">" +
    	"<input type=\"hidden\" name=\"id\" value=" + lessonList.get(i).getId() + ">" +
    	"<input type=\"hidden\" name=\"isShowing\" value=false>" +
    	"<input type=\"submit\" value=\"非表示\">" +
    	"</form>" +
    	"<br>" +
    	"<form action=\"Delete\" method=\"post\">" +
    	"<input type=\"hidden\" name=\"id\" value=" + lessonList.get(i).getId() + ">" +
    	"<input type=\"submit\" value=\"削除\">" +
    	"</form>" +
    	"<br>" +
    	"</div>");
    }
    %>
	<br>
</body>
</html>