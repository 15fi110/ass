package model;

import java.sql.SQLException;

import utility.UserConst;

public class BaseUser {
	public enum UserType{
		TEACHER,
		STUDENT,
		ADMINISTRATOR
	}
	protected int id;
	protected String password;
	protected String mail;
	protected UserType type;
	protected String userID;

	public int getId(){
		return id;
	}
	public void setUserID(String userID){
		this.userID = userID;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public boolean login(){
		boolean result = false;
		try{
			if(userID.indexOf(UserConst.TEACHER_ID) != -1){
				TeacherDAO teacherDAO = new TeacherDAO();
				result = teacherDAO.isExist(userID, password);
			}else if(userID.indexOf(UserConst.ADMINISTRATOR_ID ) != -1){
				AdministratorDAO administratorDAO = new AdministratorDAO();
				result = administratorDAO.isExist(userID, password);
			}else{
				StudentDAO studentDAO = new StudentDAO();
				result = studentDAO.isExist(userID, password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//staticメソッドにしたほうがインスタンスが無駄に作成されないが役割分担を明確にするためにインスタンスメソッドにしている
	public BaseUser getUserByUserID(String userID){
		BaseUser user = null;
		if(userID.indexOf(UserConst.TEACHER_ID) != -1){

		}else if(userID.indexOf(UserConst.ADMINISTRATOR_ID ) != -1){

		}else{

		}
		return user;
	}

	public static void logout(){

	}
}

