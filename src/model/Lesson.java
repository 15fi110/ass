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


	public static void changeShowing(int lessonId, boolean isShowing){
		LessonDAO lessonDAO = new LessonDAO();
		lessonDAO.update(lessonId, isShowing);
	}

	public static void delete(int lessonId){
		LessonDAO lessonDAO = new LessonDAO();
		lessonDAO.deleteById(lessonId);
	}

	public void setDetail(){

	}

	public void setBoardComment(){

	}

	public static void create(int teacherId, String name, String description, int grade){
		LessonDAO lessonDAO = new LessonDAO();
		lessonDAO.create(name, description, grade, teacherId);
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

	public static ArrayList<Lesson> getLessonListByTeacherId(int teacherId){
		LessonDAO lessonDAO = new LessonDAO();
		return lessonDAO.findByTeacherId(teacherId);
	}

	public static ArrayList<Lesson> getLessonListByAdministrator(){
		LessonDAO lessonDAO = new LessonDAO();
		return lessonDAO.findByAdministrator();
	}

	public static Lesson getLessonById(int id){
		LessonDAO lessonDAO = new LessonDAO();
		return lessonDAO.findById(id);
	}
}
