package model;

import java.util.ArrayList;

public class Student extends BaseUser {
	private ArrayList<Lesson> lessonList;

	public Student(int id, String password, String mail, UserType userType, String userId, ArrayList<Lesson> lessonList){
		this.id = id;
		this.password = password;
		this.mail = mail;
		this.type = userType;
		this.userID = userId;
		this.lessonList = lessonList;
	}

	public ArrayList<Lesson> getLessonList(){
		return lessonList;
	}
}
