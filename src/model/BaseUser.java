package model;

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

	public int getId(){
		return id;
	}

	public static boolean login(){

	}

	public static void logout(){

	}
}

