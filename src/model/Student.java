package model;

import java.util.ArrayList;

public class Student extends BaseUser {
	public ArrayList<Lesson> getLessonList() {
		return lessonList;
	}

	public void setLessonList(ArrayList<Lesson> lessonList) {
		this.lessonList = lessonList;
	}

	private ArrayList<Lesson> lessonList;
}
