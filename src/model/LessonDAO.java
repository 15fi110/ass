package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class LessonDAO extends BaseDAO{

    public Lesson findById(int id){
		Lesson lesson = new Lesson();
		PreparedStatement prepStmt_find;
    	String strPrepSQL_find = "SELECT * FROM lesson WHERE id = " + id;
    	
    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);

			resultSet = prepStmt_find.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String teacherId = resultSet.getString("teacher");
				Teacher teacher = new TeacherDAO().getTeacherByUserID(teacherId);
				ArrayList<Assessment> assessmentList = new AssessmentDAO().findByLessonId(id);
				ArrayList<AssessmentComment> assessmentCommentList = new AssessmentCommentDAO().findByLessonId(id);   //未完成
				ArrayList<BoardComment> boardCommentList = new BoardCommentDAO().findByLessonId(id);                   //
				boolean isShowing = resultSet.getBoolean("isShowing");
				String description = resultSet.getString("description");
				int grade = resultSet.getInt("grade");
				
				lesson.setId(id);
				lesson.setName(name);
				lesson.setTeacher(teacher);
				lesson.setAssessmentList(assessmentList);
				lesson.setAssessmentCommentList(assessmentCommentList);
				lesson.setBoardCommentList(boardCommentList);
				lesson.setShowing(isShowing);
				lesson.setDescription(description);
				lesson.setGrade(grade);
				} else {
					resultSet.close();
					prepStmt_find.close();
					connection.close();
					return null;
				}
			resultSet.close();
			prepStmt_find.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
    	return lesson;
    }
    
    public void deleteById(Lesson lesson){
    	PreparedStatement prepStmt_delete;
    	String strPrepSQL_delete = "DELETE FROM lesson WHERE id = " + lesson.getId();
    	
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_delete = connection.prepareStatement(strPrepSQL_delete);
			prepStmt_delete.executeUpdate();
			
			prepStmt_delete.close();
			connection.close();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }
    
    public void update(Lesson lesson, boolean showing){
    	PreparedStatement prepStmt_update;
    	String strPrepSQL_update;
    	if(showing){
    		strPrepSQL_update = "UPDATE lesson SET isShowing = true WHERE id =" + lesson.getId();
    	} else {
    		strPrepSQL_update = "UPDATE lesson SET isShowing = false WHERE id =" + lesson.getId();
    	}
    	
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_update = connection.prepareStatement(strPrepSQL_update);
			prepStmt_update.executeUpdate();
			
			prepStmt_update.close();
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
}
