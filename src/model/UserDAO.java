package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BaseUser.UserType;

public class UserDAO extends BaseDAO {
	private PreparedStatement prepStmt;

    String strPrepSQL_find = "SELECT * FROM assuser WHERE userid = ?";
    String strPrepSQL_login = "SELECT * FROM assuser WHERE userid = ? AND password = ?";
    String strPrepSQL_findId = "SELECT * FROM assuser WHERE id = ?";
    String strPrepSQL_findTeacher = "SELECT * FROM assuser WHERE userid LIKE '%TE%'";


	public BaseUser getUserByUserID(String userID, UserType userType) throws SQLException {
		BaseUser resultUser = null;
		switch(userType){
			case TEACHER:
				resultUser = new Teacher();
				break;
			case STUDENT:
				resultUser = new Student();
				break;
			case ADMINISTRATOR:
				resultUser = new Administrator();
				break;
		}
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_find);
			prepStmt.setString(1, userID);

			System.out.println(prepStmt);

			resultSet = prepStmt.executeQuery();

			if (resultSet.next()) {
				resultUser.setId(resultSet.getInt("id"));
				resultUser.setPassword(resultSet.getString("password"));
				resultUser.setMail(resultSet.getString("mail"));
				resultUser.setType(userType);
				resultUser.setUserID(userID);

			}else{
				resultUser = null;
			}

			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			resultUser = null;
			e.printStackTrace();
		}
		return resultUser;
	}

	public BaseUser login(String userID, String userPassword, UserType userType) throws SQLException {
		BaseUser resultUser = null;
		switch(userType){
			case TEACHER:
				resultUser = new Teacher();
				break;
			case STUDENT:
				resultUser = new Student();
				break;
			case ADMINISTRATOR:
				resultUser = new Administrator();
				break;
		}
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_login);
			prepStmt.setString(1, userID);
			prepStmt.setString(2, userPassword);

			resultSet = prepStmt.executeQuery();

			if (resultSet.next()) {
				resultUser.setId(resultSet.getInt("id"));
				resultUser.setPassword(resultSet.getString("password"));
				resultUser.setMail(resultSet.getString("mail"));
				resultUser.setType(userType);
				resultUser.setUserID(userID);
			}else{
				resultUser = null;
			}

			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			resultUser = null;
			e.printStackTrace();
		}
		return resultUser;
	}
	public BaseUser getUserById(int id, UserType userType) throws SQLException {
		BaseUser resultUser = null;
		switch(userType){
			case TEACHER:
				resultUser = new Teacher();
				break;
			case STUDENT:
				resultUser = new Student();
				break;
			case ADMINISTRATOR:
				resultUser = new Administrator();
				break;
		}
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_findId);
			prepStmt.setInt(1, id);

			resultSet = prepStmt.executeQuery();

			if (resultSet.next()) {
				resultUser.setId(id);
				resultUser.setPassword(resultSet.getString("password"));
				resultUser.setMail(resultSet.getString("mail"));
				resultUser.setType(userType);
				resultUser.setUserID(resultSet.getString("userid"));
			}else{
				resultUser = null;
			}


			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			resultUser = null;
			e.printStackTrace();
		}
		return resultUser;
	}

	public ArrayList<Teacher> getTeacherList() throws SQLException {
		ArrayList<Teacher> resultList = new ArrayList<Teacher>();
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt = connection.prepareStatement(strPrepSQL_findTeacher);

			resultSet = prepStmt.executeQuery();

			while (resultSet.next()) {
				Teacher resultUser = new Teacher();
				resultUser.setId(resultSet.getInt("id"));
				resultUser.setPassword(resultSet.getString("password"));
				resultUser.setMail(resultSet.getString("mail"));
				resultUser.setType(UserType.TEACHER);
				resultUser.setUserID(resultSet.getString("userid"));
				resultList.add(resultUser);
			}


			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
		return resultList;
	}
}