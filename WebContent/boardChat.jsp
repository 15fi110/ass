<%@page import="controller.BoardChatController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    boolean isPOST = request.getMethod().toLowerCase().equals("post");
    if (isPOST) {
    	BoardChatController.sendMessage(request.getParameter("msg"));
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
BoardChatController = {};
            (function(d) {
                function $(query) {
                    return document.querySelector(query);
                }
                function printMessage(msg) {
                    $("#msgbox").innerHTML += "<div>" + msg + "</div>";
                }
                d.connect = function() {
                    var ws = new WebSocket("ws://localhost:8080//ass/echo");
                    ws.onmessage = function(event) {
                        printMessage("Server : " + event.data);
                    };
                    d.webSocket = ws;
                    $("#connect").disabled = true;
                    $("#send").disabled = false;
                };
                d.send = function() {
                    var msg = $("#msg").value;
                    d.webSocket.send(msg);
                    printMessage("Client : " + msg);
                };
            }) (BoardChatController);
        </script>
        <form action="javascript:void(0);">
            <input type="text" id="msg" size="20">
            <input type="button" id="connect" value="Connect" onclick="BoardChatController.connect();">
            <input type="button" id="send" value="Send" onclick="BoardChatController.send();" disabled>
        </form>
        <div id="msgbox" style="border-style: solid;width: 500px;height: 400px"></div>

 <%= isPOST ? "Message was sent." : "" %>
        <form action="" method="post">
            <input type="text" name="msg">
            <input type="submit" name="submit" value="Send">
        </form>
</body>
</html>