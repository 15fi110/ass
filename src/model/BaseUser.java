package model;

import java.sql.SQLException;

import utility.UserConst;

public class BaseUser {
	public enum UserType {
		TEACHER, STUDENT, ADMINISTRATOR
	}

	protected int id;
	protected String password;
	protected String mail;
	protected UserType type;
	protected String userID;

	public int getId() {
		return id;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}

	public BaseUser login() {
		BaseUser result = null;
		try {
			UserDAO userDAO = new UserDAO();
			UserType userType;
			if (userID.indexOf(UserConst.TEACHER_ID) != -1) {
				userType = UserType.TEACHER;
			} else if (userID.indexOf(UserConst.ADMINISTRATOR_ID) != -1) {
				userType = UserType.ADMINISTRATOR;
			} else {
				userType = UserType.STUDENT;
			}
			result = userDAO.login(userID, password, userType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// staticメソッドにしたほうがインスタンスが無駄に作成されないが役割分担を明確にするためにインスタンスメソッドにしている
	public BaseUser getUserByUserID(String userID) {
		BaseUser user = null;
		if (userID.indexOf(UserConst.TEACHER_ID) != -1) {

		} else if (userID.indexOf(UserConst.ADMINISTRATOR_ID) != -1) {

		} else {

		}
		return user;
	}

	public static void logout() {

	}
}
