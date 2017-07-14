package model;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class AssessmentDAO extends BaseDAO {

    public ArrayList<Assessment> findByLessonId(int lessonId){
		PreparedStatement prepStmt_find;
    	String strPrepSQL_find = "SELECT * FROM assessment WHERE lessonid = ? ";
    	ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();
    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);

			prepStmt_find.setInt(1, lessonId);

			resultSet = prepStmt_find.executeQuery();

			while (resultSet.next()) {
				Assessment assessment = new Assessment();
				assessment.setId(resultSet.getInt("id"));
				assessment.setDate(resultSet.getDate("date"));
				assessment.setYear(resultSet.getInt("year"));
				Student student = (Student)new UserDAO().getUserByUserID(resultSet.getString("userid"), UserType.STUDENT);
				assessment.setStudent(student);
				assessment.setLessonId(resultSet.getInt("lessonid"));
				assessment.setItem1(resultSet.getInt("item1"));
				assessment.setItem2(resultSet.getInt("item2"));
				assessment.setItem3(resultSet.getInt("item3"));
				assessment.setItem4(resultSet.getInt("item4"));
				assessment.setItem5(resultSet.getInt("item5"));
				assessment.setItem6(resultSet.getInt("item6"));
				assessment.setItem7(resultSet.getInt("item7"));
				assessment.setItem8(resultSet.getInt("item8"));
				assessment.setItem9(resultSet.getInt("item9"));
				assessment.setItem10(resultSet.getInt("item10"));
				assessment.setItem11(resultSet.getInt("item11"));
				assessment.setItem12(resultSet.getInt("item12"));
				assessment.setItem13(resultSet.getInt("item13"));
				assessmentList.add(assessment);
				}
			resultSet.close();
			prepStmt_find.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
    	return assessmentList;
    }

    public void deleteById(Assessment assessment){
    	PreparedStatement prepStmt_delete;
    	String strPrepSQL_delete = "DELETE FROM assessment WHERE id = ? ";

    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_delete = connection.prepareStatement(strPrepSQL_delete);
			prepStmt_delete.setInt(1, assessment.getId());
			prepStmt_delete.executeUpdate();
			
			prepStmt_delete.close();
			connection.close();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }

    public void create(Assessment assessment){
    	PreparedStatement prepStmt_create;
    	String strPrepSQL_create = "INSERT INTO assessment VALUES (nextval('assessment_id_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	try{
    		setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_create = connection.prepareStatement(strPrepSQL_create);
			prepStmt_create.setDate(1, (Date) assessment.getDate());
			prepStmt_create.setInt(2, assessment.getYear());
			prepStmt_create.setInt(3, assessment.getStudent().getId());
			prepStmt_create.setInt(4, assessment.getLessonId());
			prepStmt_create.setInt(5, assessment.getItem1());
			prepStmt_create.setInt(6, assessment.getItem2());
			prepStmt_create.setInt(7, assessment.getItem3());
			prepStmt_create.setInt(8, assessment.getItem4());
			prepStmt_create.setInt(9, assessment.getItem5());
			prepStmt_create.setInt(10, assessment.getItem6());
			prepStmt_create.setInt(11, assessment.getItem7());
			prepStmt_create.setInt(12, assessment.getItem8());
			prepStmt_create.setInt(13, assessment.getItem9());
			prepStmt_create.setInt(14, assessment.getItem10());
			prepStmt_create.setInt(15, assessment.getItem11());
			prepStmt_create.setInt(16, assessment.getItem12());
			prepStmt_create.setInt(17, assessment.getItem13());

			prepStmt_create = connection.prepareStatement(strPrepSQL_create);
			prepStmt_create.executeUpdate();
			
			prepStmt_create.close();
			connection.close();
    	}catch(Exception e){
			e.printStackTrace();
    	}
    }
}
