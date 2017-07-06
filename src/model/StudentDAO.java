package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class StudentDAO extends BaseDAO {
	private PreparedStatement prepStmt;

    String strPrepSQL_find = "SELECT * FROM student WHERE userid = ?";
    String strPrepSQL_isExist = "SELECT * FROM student WHERE userid = ?, password = ?";


	public Student getTeacherByUserID(String userID) throws SQLException {
		Student student = null;
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_find);
			prepStmt.setString(0, userID);

			resultSet = prepStmt.executeQuery();

			if (resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setPassword(resultSet.getString("password"));
				student.setMail(resultSet.getString("mail"));
				ArrayList<Lesson> lessonList = null;
				student.setType(UserType.STUDENT);
				student.setLessonList(lessonList);
				student.setUserID(userID);
			}

			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
		return student;
	}

	public boolean isExist(String userID, String password) throws SQLException {
		// memberがDBにあるかどうかを調べる
		boolean result = false;
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_isExist);

			resultSet = prepStmt.executeQuery();

			if (resultSet.next()) {
				result = true;
			}
			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
