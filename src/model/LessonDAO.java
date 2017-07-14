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
				ArrayList<Assessment> assessmentList = new AssessmentDAO().findByLessonId(id);
				ArrayList<AssessmentComment> assessmentCommentList = new AssessmentCommentDAO().findByLessonId(id);
				ArrayList<BoardComment> boardCommentList = new BoardCommentDAO().findByLessonId(id);
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
				} else {
					resultSet.close();
					prepStmt.close();
					connection.close();
					return null;
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
			prepStmt.setInt(1, lesson.getId());
			prepStmt.executeUpdate();
			prepStmt.close();
			connection.close();
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
			prepStmt.setBoolean(1, showing);
	    	prepStmt.setInt(2, lesson.getId());
			prepStmt.executeUpdate();
			prepStmt.close();
			connection.close();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }
    
    public void create(String name,  String description, int grade){
    	PreparedStatement prepStmt_create;

    	String strPrepSQL_create = "";
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			
			strPrepSQL_create = "INSERT INTO lesson VALUES (nextval('lesson_id_seq'), '" + name + "', " + "true, '" + description + "', " + grade + ")";
			
			prepStmt_create = connection.prepareStatement(strPrepSQL_create);
			prepStmt_create.executeUpdate();
			
			prepStmt_create.close();
			connection.close();
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
