package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class AssessmentCommentDAO extends BaseDAO{
	public ArrayList<AssessmentComment> findByLessonId(int lessonId){
		ArrayList<AssessmentComment> assessmentCommentList = new ArrayList<AssessmentComment>();
		PreparedStatement prepStmt_find;
    	String strPrepSQL_find = "SELECT * FROM assessmentcomment WHERE lessonid = ? ";

    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);

			prepStmt_find.setInt(1, lessonId);

			resultSet = prepStmt_find.executeQuery();

			while (resultSet.next()) {
				AssessmentComment assessmentComment = new AssessmentComment();
				assessmentComment.setId(resultSet.getInt("id"));
				assessmentComment.setYear(resultSet.getInt("year"));
				assessmentComment.setContent(resultSet.getString("content"));
				Student student = (Student)new UserDAO().getUserById(resultSet.getInt("userid"), UserType.STUDENT);
				if(student == null){
					continue;
				}
				assessmentComment.setStudent(student);
				Lesson lesson = new LessonDAO().findById(lessonId);
				assessmentComment.setLesson(lesson);

				assessmentCommentList.add(assessmentComment);
				}
			resultSet.close();
			prepStmt_find.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
		return assessmentCommentList;
	}

	public void create(AssessmentComment assessmentComment){
    	PreparedStatement prepStmt_create;
    	String strPrepSQL_create = "INSERT INTO assessmentcomment VALUES (nextval('assessmentcomment_id_seq'), ?, ?, ?, ?, ?)";
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_create = connection.prepareStatement(strPrepSQL_create);
			prepStmt_create.setString(1, assessmentComment.getDate().toString());
			prepStmt_create.setInt(2, assessmentComment.getYear());
			prepStmt_create.setString(3, assessmentComment.getContent());
			prepStmt_create.setInt(4, assessmentComment.getStudent().getId());
			prepStmt_create.setInt(5, assessmentComment.getLesson().getId());

			prepStmt_create.executeUpdate();

			prepStmt_create.close();
			connection.close();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }
}
