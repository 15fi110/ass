package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class AssessmentDAO extends BaseDAO {
	public ArrayList<Assessment> findByLessonId(int lessonId){
		ArrayList<Assessment> assessmentList = new ArrayList<Assessment>();
		PreparedStatement prepStmt_find;
    	String strPrepSQL_find = "SELECT * FROM assessment WHERE lessonid = " + lessonId;
    	try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);

			resultSet = prepStmt_find.executeQuery();
			
			while(resultSet.next()){
				Assessment assessment = new Assessment();
				assessment.setId(resultSet.getInt("id"));
				assessment.setDate(resultSet.getDate("date"));
				assessment.setYear(resultSet.getInt("year"));
				assessment.setUserId(resultSet.getInt("userid"));
				assessment.setLessonId(lessonId);
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
	
	public void create(){
		
	}
}
