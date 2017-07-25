<%@page import="javax.print.attribute.standard.PrinterLocation"%>
<%@page import="model.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="create.css">
</head>
<body>
	<form action="Create" method="post">
	<input type="text" name="subjectName" size="30" placeholder="こ↑こ↓に入力">
	<br>
	<div class="subComment">
	<textarea id="subjectOutline" name="subjectOutline" rows="10" cols="100"
		maxlength="1000" placeholder="こ↑こ↓に入力"></textarea>
	</div>
	<select name="grade">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select>
	<br>
	<%
    ServletContext ctx = getServletContext();
	ArrayList<Teacher> teacherList = (ArrayList<Teacher>) ctx.getAttribute("teacherList");

	if(teacherList == null){
		return;
	}
	out.println("<select name=\"teacherid\">");
    for(int i = 0; i < teacherList.size(); i++){
    	out.print("<option value=" + teacherList.get(i).getId() + ">" + teacherList.get(i).getUserID() + "</option>");
    }
    %>
    <br>
    <br>
    <br>
    <input class="submit" type="submit" value="確定">
	</form>

	<input class="cancel" type="submit" value="戻る">
</body>
</html>