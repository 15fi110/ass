<%@page import="controller.BoardChatController"%>
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
//内容: クッキーを使用する(クッキーの取得)

//クッキーの配列を取得
Cookie cookies[] = request.getCookies();

//目的のクッキーを格納する変数
Cookie numberCookie = null;
Cookie passCookie = null;
Cookie lessonCookie = null;

//それぞれのクッキーに対して名前を確認
if(cookies != null) {
 for(int i = 0; i < cookies.length; i++) {
     // 名前が "accesstime" であるかチェック
     if(cookies[i].getName().equals("number")) {
         // 該当するクッキーを取得
         numberCookie = cookies[i];
     }else if(cookies[i].getName().equals("password")) {
         // 該当するクッキーを取得
         passCookie = cookies[i];
     }else if(cookies[i].getName().equals("lesson")) {
         // 該当するクッキーを取得
         lessonCookie = cookies[i];
     }
 }
}

//表示する文字列
String number;
String password;
String lessonId;

//該当するクッキーがみつからなかった場合
if(numberCookie == null) {
	number = "null";
} else { // クッキーがみつかった場合は値を取得(URLデコードする)
	number = URLDecoder.decode(numberCookie.getValue());
}

if(passCookie == null) {
	password = "null";
	}
else { // クッキーがみつかった場合は値を取得(URLデコードする)
		password = URLDecoder.decode(passCookie.getValue());
}

if(lessonCookie == null) {
	lessonId = "-1";
	}
else { // クッキーがみつかった場合は値を取得(URLデコードする)
	lessonId = URLDecoder.decode(lessonCookie.getValue());
}
%>

<script type="text/javascript">
BoardChatController = {};

			var comment = [];

            (function(d) {
                function $(query) {
                    return document.querySelector(query);
                }
                function printMessage() {
                	var messages = "";
                	for(var i = 0; i < comment.length; i++){
                		messages += "<div>" + comment[i]  + "</div>";
                	}

                	$("#msgbox").innerHTML = messages;

                    //$("#msgbox").innerHTML = "<div>" + msg + "</div>";
                }
                d.connect = function() {
                	//本番用
                    //var ws = new WebSocket("ws://150.95.151.171:8080/ass/echo");
                	//local
                    var ws = new WebSocket("ws://localhost:8080/ass/echo/<%=number%>/<%=password%>/<%=lessonId%>");
                    ws.onmessage = function(event) {
                    	if(comment.length >= 10){
                    		comment.pop();
                    	}
                    	comment.unshift(event.data + "");
                        printMessage();
                    };
                    d.webSocket = ws;
                    ws.onclose = function(closeEvent) {
                    	$("#connect").disabled = true;
                        $("#send").disabled = false;
                    };
                    $("#connect").disabled = true;
                    $("#send").disabled = false;
                };
                d.send = function() {
                    var msg = $("#msg").value;
                    d.webSocket.send(msg);
                };
            }) (BoardChatController);
        </script>
        <form action="javascript:void(0);">
            <input type="text" id="msg" size="20">
            <input type="button" id="connect" value="Connect" onclick="BoardChatController.connect();">
            <input type="button" id="send" value="Send" onclick="BoardChatController.send();" disabled>
        </form>
        <div id="msgbox" style="border-style: solid;width: 1000px;height: 600px"></div>

</body>
</html>