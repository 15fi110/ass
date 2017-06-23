package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

public class BaseDAO {
	protected String driverClassName, url, user, password;
	protected Connection connection;
	protected ResultSet resultSet;

	protected Properties props;


	protected void setup(){
		props = getProperties("db.properties");
		driverClassName = props.getProperty("driverClassName");
		url = props.getProperty("url")+props.getProperty("dbname");
		user = props.getProperty("user");
		password = props.getProperty("password");

	}

	protected static Properties getProperties(String filename) {
    Properties props = new Properties();
    try {
       props.load(new FileInputStream(filename));
    } catch (IOException e) {
       System.out.println("Warning: " + filename + " is not found.");
    }
    return props;
 }
}