package model;

import java.util.ArrayList;

public class Teacher extends BaseUser {
	private ArrayList<Lesson> lessonList;

	public ArrayList<Lesson> getLessonList() {
		return lessonList;
	}

	public void setLessonList(ArrayList<Lesson> lessonList) {
		this.lessonList = lessonList;
	}
}
