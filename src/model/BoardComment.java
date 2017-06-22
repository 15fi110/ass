package model;

import java.util.ArrayList;
import java.util.Date;

public class BoardComment {
	private int id;
	private Date date;
	private int year;
	private String content;
	private BaseUser user;
	private boolean canShowTeacher;

	public BoardComment(int id, Date date, int year, String content, BaseUser user, boolean canShowTeacher){
		this.id = id;
		this.date = date;
		this.year = year;
		this.content = content;
		this.user = user;
		this.canShowTeacher = canShowTeacher;
	}

	public int getId(){
		return id;
	}
	public Date getDate(){
		return date;
	}
	public int getYear(){
		return year;
	}
	public String getContent(){
		return content;
	}
	public BaseUser getUser(){
		return user;
	}

	public void register(String content, BaseUser user){

	}
	public static ArrayList<BoardComment> getList(int lessonId, boolean canShowTeacher){
		return null;
	}

}
