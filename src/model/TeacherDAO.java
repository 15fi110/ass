package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class TeacherDAO extends BaseDAO {
	private PreparedStatement prepStmt;

    String strPrepSQL_find = "SELECT * FROM teacher WHERE userid = ?";
    String strPrepSQL_isExist = "SELECT * FROM teacher WHERE userid = ?, password = ?";


	public Teacher getTeacherByUserID(String userID) throws SQLException {
		Teacher teacher = null;
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_find);
			prepStmt.setString(0, userID);

			resultSet = prepStmt.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String mail = resultSet.getString("mail");
				ArrayList<Lesson> lessonList = null;
				teacher = new Teacher(id, password, mail, UserType.TEACHER, userID, lessonList);
			}

			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
		return teacher;
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