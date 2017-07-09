package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class LessonDAO extends BaseDAO{

    public Lesson findById(int id){
		Lesson lesson = new Lesson();
		PreparedStatement prepStmt_find;
    	String strPrepSQL_find = "SELECT * FROM lesson WHERE id = ? ";

    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);

			prepStmt_find.setString(1, String.valueOf(id));

			resultSet = prepStmt_find.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String userid = resultSet.getString("userid");
				UserDAO userDAO = new UserDAO();
				Teacher teacher = (Teacher)userDAO.getUserByUserID(userid, UserType.TEACHER);
				ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();                         //
				ArrayList<AssessmentComment> assessmentCommentList = new ArrayList<AssessmentComment>();   //未完成
				ArrayList<BoardComment> boardCommentList = new ArrayList<BoardComment>();                   //
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
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }

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
}
