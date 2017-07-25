package model;

import java.util.ArrayList;
import java.util.Date;

public class AssessmentComment {
	private int id;
	private Date date;
	private int year;
	private String content;
	private Student student;
	private Lesson lesson;

	public void register(){
		AssessmentCommentDAO assessmentCommentDAO = new AssessmentCommentDAO();
		assessmentCommentDAO.create(this);
	}
	public static ArrayList<AssessmentComment> getList(int claasId){
		AssessmentCommentDAO assessmentCommentDAO = new AssessmentCommentDAO();
		ArrayList<AssessmentComment> resultList =  assessmentCommentDAO.findByLessonId(claasId);
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public void setUpDate(){
		this.date = new Date();
		this.year = date.getYear();
	}

}
