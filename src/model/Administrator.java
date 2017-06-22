package model;

public class Administrator extends BaseUser {

	public Administrator(int id, String password, String mail, UserType userType, String userId){
		this.id = id;
		this.password = password;
		this.mail = mail;
		this.type = userType;
		this.userID = userId;
	}
}
