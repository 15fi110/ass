<%@page import="javax.swing.text.AbstractDocument.BranchElement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="utility.AssessmentItem"%>
<%@page import="model.Assessment"%>
<%@page import="model.AssessmentComment"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="confirm.css">
</head>
<body>
	<br>
	<%
	ServletContext ctx = getServletContext();
	Assessment assessment = (Assessment)ctx.getAttribute("assessment");
	AssessmentComment comment = (AssessmentComment)ctx.getAttribute("assessmentComment");

	if(assessment == null || comment == null){
		return;
	}
	%>
	<p>
	評価内容
	<br>
	<br>
	<%
		out.println(
					"<a>1." + AssessmentItem.ITEM1 + ": " + assessment.getItem1() +  "</a><br>" +
					"<a>2." + AssessmentItem.ITEM2 + ": " + assessment.getItem2() +  "</a><br>" +
					"<a>3." + AssessmentItem.ITEM3 + ": " + assessment.getItem3() +  "</a><br>" +
					"<a>4." + AssessmentItem.ITEM4 + ": " + assessment.getItem4() +  "</a><br>" +
					"<a>5." + AssessmentItem.ITEM5 + ": " + assessment.getItem5() +  "</a><br>" +
					"<a>6." + AssessmentItem.ITEM6 + ": " + assessment.getItem6() +  "</a><br>" +
					"<a>7." + AssessmentItem.ITEM7 + ": " + assessment.getItem7() +  "</a><br>" +
					"<a>8." + AssessmentItem.ITEM8 + ": " + assessment.getItem8() +  "</a><br>" +
					"<a>9." + AssessmentItem.ITEM9 + ": " + assessment.getItem9() +  "</a><br>" +
					"<a>10." + AssessmentItem.ITEM10 + ": " + assessment.getItem10() +  "</a><br>" +
					"<a>11." + AssessmentItem.ITEM11 + ": " + assessment.getItem11() +  "</a><br>" +
					"<a>12." + AssessmentItem.ITEM12 + ": " + assessment.getItem12() +  "</a><br>" +
					"<a>13." + AssessmentItem.ITEM13 + ": " + assessment.getItem13() +  "</a><br>" +
					"<br>" +
					"<a>コメント</a><br>" +
					"<a>" + comment.getContent() + "</a><br>"
				);
	%>
	</p>
	<br>
	<form action="Confirm" method="post">
    	<input class="submit" type="submit" value="投稿する">
    </form>
    <form action="GetAssess" method="get">
    	<input class="cancel" type="submit" value="取り消し">
    </form>
</body>
</html>