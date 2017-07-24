package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.BaseUser;
import model.BoardComment;


@ServerEndpoint("/echo/{number}/{pass}/{lesson}")
public class BoardChatController {

//	 private static Set<Session> ses = new CopyOnWriteArraySet<>();
	 private static HashMap<Integer, Set<Session>> sesMap = new HashMap<Integer, Set<Session>>();

	    @OnOpen
	    public void onOpen(Session session, @PathParam("number") String number, @PathParam("pass") String pass, @PathParam("lesson") int lessonId) {
	    	System.out.println("onOpen : " + session);
	    	if(lessonId < 0){
	    		return;
	    	}
	    	BaseUser user = new BaseUser();
	    	user.setUserID(number);
	    	user.setPassword(pass);
	    	user = user.login();
	    	if(user == null){
	    		try{
	    			session.close();
	    		}catch(Exception e){

	    		}
	    	}else{
	    		if(!sesMap.containsKey(lessonId)){
	    			sesMap.put(lessonId, new CopyOnWriteArraySet<>());
	    		}
	    		try{
	    		sesMap.get(lessonId).add(session);
	    		ArrayList<BoardComment> list = BoardComment.getList(lessonId, true);
	    		for(BoardComment comment : list){
	    			session.getAsyncRemote().sendText(comment.getUser().getUserID() + ": " + comment.getContent());
	    		}
	    		}catch(Exception e){
	    			System.out.println(e);
	    		}
	    	}
	    }

	    @OnMessage
	    public void onMessage(String text, @PathParam("number") String number, @PathParam("pass") String pass, @PathParam("lesson") int lessonId) {
	    	BoardComment comment = new BoardComment();
	    	BaseUser user = new BaseUser();
	    	user = user.getUserByUserID(number);
	    	System.out.println(number);
	    	System.out.println(user);
	    	if(user == null){
	    		return;
	    	}
	    	comment.register(text, user, lessonId);
	    	for (Session ses : sesMap.get(lessonId)) {
	            ses.getAsyncRemote().sendText(number + ": " + text);
	        }
	        //return "echo => " + text;
	    }

	    @OnClose
	    public void onClose(Session session, @PathParam("lesson") int lessonId) {
	        System.out.println("onClose : " + session);
	        sesMap.get(lessonId).remove(session);
	    }

//	    public static void sendMessage(String msg) {
//	        for (Session ses : sesMap.get(lessonId)) {
//	            ses.getAsyncRemote().sendText(msg);
//	        }
//	    }


}
