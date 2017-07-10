package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class LessonDAO extends BaseDAO{

	private PreparedStatement prepStmt;
	private String strPrepSQL_findList = "SELECT * FROM lesson WHERE id IN (SELECT lessonid FROM assessment WHERE userid = ?) ";
	private String strPrepSQL_find = "SELECT * FROM lesson WHERE id = ? ";
	private String strPrepSQL_delete = "DELETE FROM lesson WHERE id = ? ";
	private String strPrepSQL_update = "UPDATE lesson SET isShowing = ? WHERE id = ?";

    public Lesson findById(int id){
		Lesson lesson = null;

    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_find);

			prepStmt.setInt(1, id);

			resultSet = prepStmt.executeQuery();

			if (resultSet.next()) {
				lesson = new Lesson();
				String name = resultSet.getString("name");
				int lessonId = resultSet.getInt("id");
				UserDAO userDAO = new UserDAO();
				Teacher teacher = (Teacher)userDAO.getUserById(id, UserType.TEACHER);
//				ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();                         //
//				ArrayList<AssessmentComment> assessmentCommentList = new ArrayList<AssessmentComment>();   //未完成
//				ArrayList<BoardComment> boardCommentList = new ArrayList<BoardComment>();                   //
				boolean isShowing = resultSet.getBoolean("isshowing");
				String description = resultSet.getString("description");
				int grade = resultSet.getInt("grade");

				lesson.setId(lessonId);
				lesson.setName(name);
				lesson.setTeacher(teacher);
				lesson.setAssessmentList(null);
				lesson.setAssessmentCommentList(null);
				lesson.setBoardCommentList(null);
				lesson.setShowing(isShowing);
				lesson.setDescription(description);
				lesson.setGrade(grade);
				}

			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
    	return lesson;
    }

    public void deleteById(Lesson lesson){
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_delete);
			prepStmt.setString(1, String.valueOf(lesson.getId()));
			prepStmt.executeUpdate();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }

    public void update(Lesson lesson, boolean showing){
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_update);
			prepStmt.setString(1, String.valueOf(showing));
	    	prepStmt.setString(2, String.valueOf(lesson.getId()));
			prepStmt.executeUpdate();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }


    //TODO::修正
    public void create(String name,  Teacher teacher,  String description, int grade){
    	PreparedStatement prepStmt_show, prepStmt_create;
    	String strPrepSQL_show = "SELECT * FROM lesson";
    	String strPrepSQL_create = "";
    	int count = 0;
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_show = connection.prepareStatement(strPrepSQL_show);
			resultSet = prepStmt_show.executeQuery();

			while(resultSet.next()){
				count++;
			}

			strPrepSQL_create = "INSERT INTO lesson VALUES (" + count + "," + name + "," + teacher.getId() + "," + "true," + description + "," + grade + ")";//未完成

			prepStmt_create = connection.prepareStatement(strPrepSQL_create);
			prepStmt_create.executeUpdate();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }

    public ArrayList<Lesson> findByUserId(int id){
		ArrayList<Lesson> resultList = new ArrayList<Lesson>();

    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_findList);

			prepStmt.setInt(1, id);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				Lesson lesson = new Lesson();
				String name = resultSet.getString("name");
				int lessonId = resultSet.getInt("id");
				UserDAO userDAO = new UserDAO();
				Teacher teacher = (Teacher)userDAO.getUserById(id, UserType.TEACHER);
//				ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();                         //
//				ArrayList<AssessmentComment> assessmentCommentList = new ArrayList<AssessmentComment>();   //未完成
//				ArrayList<BoardComment> boardCommentList = new ArrayList<BoardComment>();                   //
				boolean isShowing = resultSet.getBoolean("isshowing");
				String description = resultSet.getString("description");
				int grade = resultSet.getInt("grade");

				lesson.setId(lessonId);
				lesson.setName(name);
				lesson.setTeacher(teacher);
				lesson.setAssessmentList(null);
				lesson.setAssessmentCommentList(null);
				lesson.setBoardCommentList(null);
				lesson.setShowing(isShowing);
				lesson.setDescription(description);
				lesson.setGrade(grade);
				resultList.add(lesson);
				}

			resultSet.close();
			resultSet.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
    	return resultList;
    }
}
