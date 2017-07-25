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
import model.BaseUser.UserType;
import model.BoardComment;


@ServerEndpoint("/echo/{number}/{pass}/{lesson}/{canTeacher}")
public class BoardChatController {

//	 private static Set<Session> ses = new CopyOnWriteArraySet<>();
	 private static HashMap<Integer, Set<Session>> sesMap = new HashMap<Integer, Set<Session>>();
	 private static HashMap<Integer, Set<Session>> teacherSesMap = new HashMap<Integer, Set<Session>>();

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
	    		if(user.getType() == UserType.STUDENT){
	    			if(!sesMap.containsKey(lessonId)){
	    				sesMap.put(lessonId, new CopyOnWriteArraySet<>());
	    			}
	    			try{
	    				sesMap.get(lessonId).add(session);
	    				ArrayList<BoardComment> list = BoardComment.getList(lessonId);
	    				for(BoardComment comment : list){
	    					System.out.println(comment.getContent());
	    					session.getBasicRemote().sendText(comment.getUser().getUserID() + ": " + comment.getContent());
//	    					getAsyncRemote().sendText(comment.getUser().getUserID() + ": " + comment.getContent());
	    				}
	    			}catch(Exception e){
	    				System.out.println(e);
	    			}
	    		}else{
	    			if(!teacherSesMap.containsKey(lessonId)){
	    				teacherSesMap.put(lessonId, new CopyOnWriteArraySet<>());
	    			}
	    			try{
	    				teacherSesMap.get(lessonId).add(session);
	    				ArrayList<BoardComment> list = BoardComment.getListByTeaher(lessonId);
	    				for(BoardComment comment : list){
	    					session.getBasicRemote().sendText(comment.getUser().getUserID() + ": " + comment.getContent());
	    				}
	    			}catch(Exception e){
	    				System.out.println(e);
	    			}
	    		}
	    	}
	    }

	    @OnMessage
	    public void onMessage(String text, @PathParam("number") String number, @PathParam("pass") String pass,
	    		@PathParam("lesson") int lessonId, @PathParam("canTeacher") boolean canShowTeacher) {
	    	BoardComment comment = new BoardComment();
	    	BaseUser user = new BaseUser();
	    	user = user.getUserByUserID(number);
	    	if(user == null){
	    		return;
	    	}

	    	System.out.println(canShowTeacher);
	    	comment.register(text, user, lessonId, canShowTeacher);
	    	for (Session ses : sesMap.get(lessonId)) {
	            ses.getAsyncRemote().sendText(number + ": " + text);
	        }
	    	if(canShowTeacher){
	    		for (Session ses : teacherSesMap.get(lessonId)) {
		            ses.getAsyncRemote().sendText(number + ": " + text);
		        }
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
