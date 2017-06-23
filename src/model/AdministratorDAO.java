package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.BaseUser.UserType;

public class AdministratorDAO extends BaseDAO {
	private PreparedStatement prepStmt;

    String strPrepSQL_find = "SELECT * FROM administrator WHERE userid = ?";
    String strPrepSQL_isExist = "SELECT * FROM administrator WHERE userid = ?, password = ?";


	public Administrator getTeacherByUserID(String userID) throws SQLException {
		Administrator administrator = null;
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
				administrator = new Administrator(id, password, mail, UserType.ADMINISTRATOR, userID);
			}

			resultSet.close();
			prepStmt.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
		return administrator;
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
