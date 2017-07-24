<%@page import="model.BaseUser.UserType"%>
<%@page import="model.Lesson"%>
<%@page import="model.BaseUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="review.css">
</head>
<body>

	<%
	ServletContext ctx = getServletContext();
	Lesson lesson = (Lesson) ctx.getAttribute("lesson");

	if(lesson == null){
		return;
	}
	%>
	<form action="Lesson" method="post">
    	<input type="hidden" name="id" value="<% out.print(lesson.getId()); %>">
    	<input class="goIndividual" type="submit" value="個別ページへ">
    </form>
    <form action="LessonList" method="get">
    	<input class="goIndex" type="submit" value="授業一覧へ">
    </form>
    <br>
	<br>
	<br>
	<br>
	<br>
    <% if(session.getAttribute("user") != null){
    		BaseUser user = (BaseUser)session.getAttribute("user");
			if(user.getType() == UserType.STUDENT){
				out.print(
						"<form action=\"GetAssess\" method=\"get\">" +
				    	"<input type=\"submit\" value=\"評価を行う\">" +
				    	"</form>"
			    );
			}

    	}%>


	<img src='<%=request.getContextPath()%>/chart.png'>

</body>
</html>