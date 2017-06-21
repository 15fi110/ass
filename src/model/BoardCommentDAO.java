package model;

import java.sql.*;

public class BoardCommentDAO extends BaseDAO {
	
	private PreparedStatement prepStmt_find;
	private PreparedStatement prepStmt_create;
	
    String strPrepSQL_find = "SELECT * FROM address";
    String strPrepSQL_create = "SELECT * FROM address";
    
	public static List<BoardComment> findByLessonId(Type type, int lessonId, int page, boolean canShowTeacher){
		ArrayList<BoardComment> commentList = new ArrayList<BoardComment>();
		try
		{
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);

			resultSet = prepStmt_find.executeQuery();

			while (resultSet.next()) {
				BoardCommnet comment = new BoardComment();
				comment.id = resultSet.getInt("id");
				comment.date = resultSet.getDate("date");
				comment.year = resultSet.getInt("year");
				comment.content = resultSet.getString("content");
				comment.user = resultSet.getInt("user");
				comment.canShowTeacher = resultSet.getBoolean("canShowTeacher");
				commentList.Add(comment);
			}

			resultSet.close();
			prepStmt_find.close();
			connection.close();
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
	}
}
