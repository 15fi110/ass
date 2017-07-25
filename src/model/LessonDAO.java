package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class LessonDAO extends BaseDAO{

	private PreparedStatement prepStmt;
	private String strPrepSQL_findList = "SELECT * FROM lesson WHERE id IN (SELECT lessonid FROM assessment WHERE userid = ?) ";
	private String strPrepSQL_findListByTeacher = "SELECT * FROM lesson WHERE userid = ? ";
	private String strPrepSQL_findListByAdministrator = "SELECT * FROM lesson";
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

//				ArrayList<Assessment> assessmentList = new AssessmentDAO().findByLessonId(id);
//				ArrayList<AssessmentComment> assessmentCommentList = new AssessmentCommentDAO().findByLessonId(id);   //未完成
//				ArrayList<BoardComment> boardCommentList = new BoardCommentDAO().findByLessonId(id);                 //

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

    public void deleteById(int lessonId){
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);

			prepStmt = connection.prepareStatement(strPrepSQL_delete);
			prepStmt.setInt(1, lessonId);
			prepStmt.executeUpdate();
			prepStmt.close();
			connection.close();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }

    public void update(int lessonId, boolean showing){
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);

			prepStmt = connection.prepareStatement(strPrepSQL_update);
			prepStmt.setBoolean(1, showing);
	    	prepStmt.setInt(2, lessonId);
			prepStmt.executeUpdate();
			prepStmt.close();
			connection.close();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }

    public void create(String name,  String description, int grade, int teacherId){
    	PreparedStatement prepStmt_create;

    	String strPrepSQL_create = "";
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);

			strPrepSQL_create = "INSERT INTO lesson VALUES (nextval('lesson_id_seq'), '" + name + "', " + "true, '" + description + "', " + teacherId + "," + grade + ")";

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
				int userId = resultSet.getInt("userid");
				UserDAO userDAO = new UserDAO();
				Teacher teacher = (Teacher)userDAO.getUserById(userId, UserType.TEACHER);
//				ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();                         //
//				ArrayList<AssessmentComment> assessmentCommentList = new ArrayList<AssessmentComment>();   //未完成
//				ArrayList<BoardComment> boardCommentList = new ArrayList<BoardComment>();                   //
				boolean isShowing = resultSet.getBoolean("isshowing");
				if(isShowing == false){
					continue;
				}
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

    public ArrayList<Lesson> findByTeacherId(int id){
		ArrayList<Lesson> resultList = new ArrayList<Lesson>();

    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_findListByTeacher);

			prepStmt.setInt(1, id);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				Lesson lesson = new Lesson();
				String name = resultSet.getString("name");
				int lessonId = resultSet.getInt("id");
				int userId = resultSet.getInt("userid");
				UserDAO userDAO = new UserDAO();
				Teacher teacher = (Teacher)userDAO.getUserById(userId, UserType.TEACHER);
//				ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();                         //
//				ArrayList<AssessmentComment> assessmentCommentList = new ArrayList<AssessmentComment>();   //未完成
//				ArrayList<BoardComment> boardCommentList = new ArrayList<BoardComment>();                   //
				boolean isShowing = resultSet.getBoolean("isshowing");
				if(isShowing == false){
					continue;
				}
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

    public ArrayList<Lesson> findByAdministrator(){
		ArrayList<Lesson> resultList = new ArrayList<Lesson>();

    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_findListByAdministrator);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				Lesson lesson = new Lesson();
				String name = resultSet.getString("name");
				int lessonId = resultSet.getInt("id");
				int userId = resultSet.getInt("userid");
				UserDAO userDAO = new UserDAO();
				Teacher teacher = (Teacher)userDAO.getUserById(userId, UserType.TEACHER);
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
