package model;

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

	public static boolean login(String userID, String password){
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
		}catch(Exception e){

		}
		return result;
	}

	public static BaseUser getUserByUserID(String userID){
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

