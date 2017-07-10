package model;

import java.util.ArrayList;

public class Lesson {
	private int id;
	private String name;
	private Teacher teacher;
	private ArrayList<Assessment> assessmentList;
	private ArrayList<AssessmentComment> assessmentCommentList;
	private ArrayList<BoardComment> boardCommentList;
	private boolean isShowing;
	private String description;
	private int grade;


	public boolean changeShowing(){
		return isShowing;
	}

	public void delete(){

	}

	public void setDetail(){

	}

	public void setBoardComment(){

	}

	public void create(int teacherId, String name, String description, int grade){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Assessment> getAssessmentList() {
		return assessmentList;
	}

	public void setAssessmentList(ArrayList<Assessment> assessmentList) {
		this.assessmentList = assessmentList;
	}

	public ArrayList<AssessmentComment> getAssessmentCommentList() {
		return assessmentCommentList;
	}

	public void setAssessmentCommentList(ArrayList<AssessmentComment> assessmentCommentList) {
		this.assessmentCommentList = assessmentCommentList;
	}

	public ArrayList<BoardComment> getBoardCommentList() {
		return boardCommentList;
	}

	public void setBoardCommentList(ArrayList<BoardComment> boardCommentList) {
		this.boardCommentList = boardCommentList;
	}

	public boolean isShowing() {
		return isShowing;
	}

	public void setShowing(boolean isShowing) {
		this.isShowing = isShowing;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public static ArrayList<Lesson> getLessonListByUserId(int userId){
		LessonDAO lessonDAO = new LessonDAO();
		return lessonDAO.findByUserId(userId);
	}
}
