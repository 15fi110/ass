package model;

import java.util.ArrayList;
import java.util.Date;

public class Assessment {
	private int id;
	private Date date;
	private int year;
	private Student student;
	private int lessonId;
	private int item1;
	private int item2;
	private int item3;
	private int item4;
	private int item5;
	private int item6;
	private int item7;
	private int item8;
	private int item9;
	private int item10;
	private int item11;
	private int item12;
	private int item13;

	public void register(){

	}
	public AssessmentResult aggregate(ArrayList<Assessment> list){
		AssessmentResult result = new AssessmentResult();
		float item1 = 0;
		float item2 = 0;
		float item3 = 0;
		float item4 = 0;
		float item5 = 0;
		float item6 = 0;
		float item7 = 0;
		float item8 = 0;
		float item9 = 0;
		float item10 = 0;
		float item11 = 0;
		float item12 = 0;
		float item13 = 0;
		for(Assessment assessment : list){
			if(assessment.getItem1() == 0){
				continue;
			}
			item1 += (float)assessment.getItem1();
			item2 += (float)assessment.getItem2();
			item3 += (float)assessment.getItem3();
			item4 += (float)assessment.getItem4();
			item5 += (float)assessment.getItem5();
			item6 += (float)assessment.getItem6();
			item7 += (float)assessment.getItem7();
			item8 += (float)assessment.getItem8();
			item9 += (float)assessment.getItem9();
			item10 += (float)assessment.getItem10();
			item11 += (float)assessment.getItem11();
			item12 += (float)assessment.getItem12();
			item13 += (float)assessment.getItem13();
		}
		result.setItem1(item1 / (float)list.size());
		result.setItem2(item2 / (float)list.size());
		result.setItem3(item3 / (float)list.size());
		result.setItem4(item4 / (float)list.size());
		result.setItem5(item5 / (float)list.size());
		result.setItem6(item6 / (float)list.size());
		result.setItem7(item7 / (float)list.size());
		result.setItem8(item8 / (float)list.size());
		result.setItem9(item9 / (float)list.size());
		result.setItem10(item10 / (float)list.size());
		result.setItem11(item11 / (float)list.size());
		result.setItem12(item12 / (float)list.size());
		result.setItem13(item13 / (float)list.size());
		LessonDAO lessonDAO = new LessonDAO();
		Lesson lesson = lessonDAO.findById(lessonId);
		String description;
		if(lesson == null){
			description = "";
		}else{
			description = lesson.getName();
		}
		result.setDescription(description);
		return result;
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
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getItem1() {
		return item1;
	}
	public void setItem1(int item1) {
		this.item1 = item1;
	}
	public int getItem2() {
		return item2;
	}
	public void setItem2(int item2) {
		this.item2 = item2;
	}
	public int getItem3() {
		return item3;
	}
	public void setItem3(int item3) {
		this.item3 = item3;
	}
	public int getItem4() {
		return item4;
	}
	public void setItem4(int item4) {
		this.item4 = item4;
	}
	public int getItem5() {
		return item5;
	}
	public void setItem5(int item5) {
		this.item5 = item5;
	}
	public int getItem6() {
		return item6;
	}
	public void setItem6(int item6) {
		this.item6 = item6;
	}
	public int getItem7() {
		return item7;
	}
	public void setItem7(int item7) {
		this.item7 = item7;
	}
	public int getItem8() {
		return item8;
	}
	public void setItem8(int item8) {
		this.item8 = item8;
	}
	public int getItem9() {
		return item9;
	}
	public void setItem9(int item9) {
		this.item9 = item9;
	}
	public int getItem10() {
		return item10;
	}
	public void setItem10(int item10) {
		this.item10 = item10;
	}
	public int getItem11() {
		return item11;
	}
	public void setItem11(int item11) {
		this.item11 = item11;
	}
	public int getItem12() {
		return item12;
	}
	public void setItem12(int item12) {
		this.item12 = item12;
	}
	public int getItem13() {
		return item13;
	}
	public void setItem13(int item13) {
		this.item13 = item13;
	}

	public void setUpDate(){
		this.date = new Date();
		this.year = date.getYear();
	}

}
