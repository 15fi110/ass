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

	public void register(String content, BaseUser user){

	}
	public static ArrayList<BoardComment> getList(int lessonId, boolean canShowTeacher){
		return null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BaseUser getUser() {
		return user;
	}
	public void setUser(BaseUser user) {
		this.user = user;
	}
	public boolean isCanShowTeacher() {
		return canShowTeacher;
	}
	public void setCanShowTeacher(boolean canShowTeacher) {
		this.canShowTeacher = canShowTeacher;
	}
	
	

}
