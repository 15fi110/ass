package model;

public class BoardComment {
	private int id;
	private DateTime date;
	private int year;
	private String content;
	private BaseUser user;
	private boolean canShowTeacher;
	
	public BoardComment(int id, DateTime date, int year, String content, BaseUSer user, boolean canShowTeacher){
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
	public DateTIme getDate(){
		return date;
	}
	public int getYear(){
		return year;
	}
	public String getContent(){
		
	}
	public BaseUser getUser(){
		
	}
	
	public void register(String content, BaseUser user){
		
	}
	public static List<BoardComment> getList(int lessonId, boolean canShowTeacher){
		
	}
	
}
