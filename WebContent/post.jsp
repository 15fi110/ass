<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="utility.AssessmentItem"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="詳細へ">
	<br>
	<form action="Assess" method="post">
	<a><%out.print(AssessmentItem.ITEM1);%></a><br>
	<input type="radio" name="item1" value="1">1
	<input type="radio" name="item1" value="2">2
	<input type="radio" name="item1" value="3">3
	<input type="radio" name="item1" value="4">4
	<input type="radio" name="item1" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM2);%></a><br>
	<input type="radio" name="item2" value="1">1
	<input type="radio" name="item2" value="2">2
	<input type="radio" name="item2" value="3">3
	<input type="radio" name="item2" value="4">4
	<input type="radio" name="item2" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM3);%></a><br>
	<input type="radio" name="item3" value="1">1
	<input type="radio" name="item3" value="2">2
	<input type="radio" name="item3" value="3">3
	<input type="radio" name="item3" value="4">4
	<input type="radio" name="item3" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM4);%></a><br>
	<input type="radio" name="item4" value="1">1
	<input type="radio" name="item4" value="2">2
	<input type="radio" name="item4" value="3">3
	<input type="radio" name="item4" value="4">4
	<input type="radio" name="item4" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM5);%></a><br>
	<input type="radio" name="item5" value="1">1
	<input type="radio" name="item5" value="2">2
	<input type="radio" name="item5" value="3">3
	<input type="radio" name="item5" value="4">4
	<input type="radio" name="item5" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM6);%></a><br>
	<input type="radio" name="item6" value="1">1
	<input type="radio" name="item6" value="2">2
	<input type="radio" name="item6" value="3">3
	<input type="radio" name="item6" value="4">4
	<input type="radio" name="item6" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM7);%></a><br>
	<input type="radio" name="item7" value="1">1
	<input type="radio" name="item7" value="2">2
	<input type="radio" name="item7" value="3">3
	<input type="radio" name="item7" value="4">4
	<input type="radio" name="item7" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM8);%></a><br>
	<input type="radio" name="item8" value="1">1
	<input type="radio" name="item8" value="2">2
	<input type="radio" name="item8" value="3">3
	<input type="radio" name="item8" value="4">4
	<input type="radio" name="item8" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM9);%></a><br>
	<input type="radio" name="item9" value="1">1
	<input type="radio" name="item9" value="2">2
	<input type="radio" name="item9" value="3">3
	<input type="radio" name="item9" value="4">4
	<input type="radio" name="item9" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM10);%></a><br>
	<input type="radio" name="item10" value="1">1
	<input type="radio" name="item10" value="2">2
	<input type="radio" name="item10" value="3">3
	<input type="radio" name="item10" value="4">4
	<input type="radio" name="item10" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM11);%></a><br>
	<input type="radio" name="item11" value="1">1
	<input type="radio" name="item11" value="2">2
	<input type="radio" name="item11" value="3">3
	<input type="radio" name="item11" value="4">4
	<input type="radio" name="item11" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM12);%></a><br>
	<input type="radio" name="item12" value="1">1
	<input type="radio" name="item12" value="2">2
	<input type="radio" name="item12" value="3">3
	<input type="radio" name="item12" value="4">4
	<input type="radio" name="item12" value="5">5
	<br>
	<a><%out.print(AssessmentItem.ITEM13);%></a><br>
	<input type="radio" name="item13" value="1">1
	<input type="radio" name="item13" value="2">2
	<input type="radio" name="item13" value="3">3
	<input type="radio" name="item13" value="4">4
	<input type="radio" name="item13" value="5">5
	<br>
	<textarea id="comment" name="comment" maxlength="400"
		placeholder="こ↑こ↓に入力"></textarea>
	<br>
    	<input type="submit" value="投稿する">
    </form>

</body>
</html>