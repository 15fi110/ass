package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

import model.BaseUser.UserType;

public class BoardCommentDAO extends BaseDAO {

	private PreparedStatement prepStmt_find;
	private PreparedStatement prepStmt_create;

    String strPrepSQL_find = "SELECT * FROM address";
    String strPrepSQL_create = "SELECT * FROM address";

	public ArrayList<BoardComment> findByLessonId(UserType type, int lessonId, int page, boolean canShowTeacher){
		ArrayList<BoardComment> commentList = new ArrayList<BoardComment>();
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);

			resultSet = prepStmt_find.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				Date date = resultSet.getDate("date");
				int year = resultSet.getInt("year");
				String content = resultSet.getString("content");
				String userID = resultSet.getString("userID");
				BaseUser user = BaseUser.getUserByUserID(userID);
				BoardComment comment = new BoardComment(id, date, year,content, user, canShowTeacher);
				commentList.add(comment);
			}

			resultSet.close();
			prepStmt_find.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
		return commentList;
	}
}
