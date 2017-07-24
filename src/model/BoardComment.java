package model;

import java.util.ArrayList;
import java.util.Date;

public class BoardComment {
	private int id;
	private Date date;
	private int year;
	private String content;
	private BaseUser user;
	private int lessonId;
	private boolean canShowTeacher;

	public void register(String content, BaseUser user, int lessonId){
		BoardCommentDAO boardCommentDAO = new BoardCommentDAO();
		date = new Date();
		year = date.getYear() + 1900;
		canShowTeacher = true;
		this.lessonId = lessonId;
		this.user = user;
		this.content = content;
		boardCommentDAO.create(this);
	}
	public static ArrayList<BoardComment> getList(int lessonId, boolean canShowTeacher){
		BoardCommentDAO boardCommentDAO = new BoardCommentDAO();
		ArrayList<BoardComment> resultList = new ArrayList<BoardComment>();
		resultList = boardCommentDAO.findByLessonId(lessonId);
		return resultList;
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

	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public boolean isCanShowTeacher() {
		return canShowTeacher;
	}
	public void setCanShowTeacher(boolean canShowTeacher) {
		this.canShowTeacher = canShowTeacher;
	}



}
