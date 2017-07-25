<%@page import="model.AssessmentResult"%>
<%@page import="model.BaseUser.UserType"%>
<%@page import="model.Lesson"%>
<%@page import="model.BaseUser"%>
<%@page import="model.Assessment"%>
<%@page import="model.AssessmentComment"%>
<%@page import="utility.AssessmentItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細</title>
<link rel="stylesheet" type="text/css" href="review.css">
</head>
<body>

	<%
	ServletContext ctx = getServletContext();
	Lesson lesson = (Lesson) ctx.getAttribute("lesson");
	AssessmentResult assessmentResult = (AssessmentResult)ctx.getAttribute("assessmentResult");
	ArrayList<AssessmentComment> commentList = (ArrayList<AssessmentComment>)ctx.getAttribute("assessmentCommentList");

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
	<%
		out.println(
				"<a>" + lesson.getName() + "</a><br>" +
				"<a>" + lesson.getDescription() + "</a><br>"
				);
	%>
	<img src='<%=request.getContextPath()%>/chart.png'>
	<br>
	<br>
		<%
		out.println(
					"<a>1." + AssessmentItem.ITEM1 + ": " + assessmentResult.getItem1() +  "</a><br>" +
					"<a>2." + AssessmentItem.ITEM2 + ": " + assessmentResult.getItem2() +  "</a><br>" +
					"<a>3." + AssessmentItem.ITEM3 + ": " + assessmentResult.getItem3() +  "</a><br>" +
					"<a>4." + AssessmentItem.ITEM4 + ": " + assessmentResult.getItem4() +  "</a><br>" +
					"<a>5." + AssessmentItem.ITEM5 + ": " + assessmentResult.getItem5() +  "</a><br>" +
					"<a>6." + AssessmentItem.ITEM6 + ": " + assessmentResult.getItem6() +  "</a><br>" +
					"<a>7." + AssessmentItem.ITEM7 + ": " + assessmentResult.getItem7() +  "</a><br>" +
					"<a>8." + AssessmentItem.ITEM8 + ": " + assessmentResult.getItem8() +  "</a><br>" +
					"<a>9." + AssessmentItem.ITEM9 + ": " + assessmentResult.getItem9() +  "</a><br>" +
					"<a>10." + AssessmentItem.ITEM10 + ": " + assessmentResult.getItem10() +  "</a><br>" +
					"<a>11." + AssessmentItem.ITEM11 + ": " + assessmentResult.getItem11() +  "</a><br>" +
					"<a>12." + AssessmentItem.ITEM12 + ": " + assessmentResult.getItem12() +  "</a><br>" +
					"<a>13." + AssessmentItem.ITEM13 + ": " + assessmentResult.getItem13() +  "</a><br>"
				);
	%>
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

    	<br>
	<br>
		<%
		for(AssessmentComment comment : commentList){
			out.println("<a>" + comment.getStudent().getUserID() + ": " + comment.getContent() + "</a><br>");
		}
	%>
	<br>
	<br>




</body>
</html>