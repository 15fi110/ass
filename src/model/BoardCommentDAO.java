package model;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class BoardCommentDAO extends BaseDAO {

	private PreparedStatement prepStmt_find;
	private PreparedStatement prepStmt_create;

	String strPrepSQL_find = "SELECT * FROM boardcomment  WHERE lessonid = ? OFFSET 0 LIMIT 20";
	String strPrepSQL_findByTeacher = "SELECT * FROM boardcomment  WHERE lessonid = ? AND canshowteacher = true OFFSET 0 LIMIT 20";
	String strPrepSQL_create = "INSERT INTO boardcomment VALUES (nextval('boardcomment_id_seq'),?,?,?,?,?,?)";

	public ArrayList<BoardComment> findByLessonId(int lessonId) {
		ArrayList<BoardComment> commentList = new ArrayList<BoardComment>();
		try {
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_find);
			prepStmt_find.setInt(1, lessonId);

			resultSet = prepStmt_find.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				// Date date = resultSet.getDate("date");
				// int year = resultSet.getInt("year");
				String content = resultSet.getString("content");
				String userID = resultSet.getString("userID");
				BaseUser user = BaseUser.getUserByUserID(userID);
				BoardComment comment = new BoardComment();
				comment.setId(id);
				comment.setUser(user);
				comment.setContent(content);
				commentList.add(comment);
			}

			resultSet.close();
			prepStmt_find.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentList;
	}

	public ArrayList<BoardComment> findByLessonIdTeacher(int lessonId) {
		ArrayList<BoardComment> commentList = new ArrayList<BoardComment>();
		try {
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_find = connection.prepareStatement(strPrepSQL_findByTeacher);
			prepStmt_find.setInt(1, lessonId);

			resultSet = prepStmt_find.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				// Date date = resultSet.getDate("date");
				// int year = resultSet.getInt("year");
				String content = resultSet.getString("content");
				String userID = resultSet.getString("userID");
				BaseUser user = BaseUser.getUserByUserID(userID);
				BoardComment comment = new BoardComment();
				comment.setId(id);
				comment.setUser(user);
				comment.setContent(content);
				commentList.add(comment);
			}

			resultSet.close();
			prepStmt_find.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentList;
	}

	public void create(BoardComment comment) {
		PreparedStatement prepStmt_create;
		try {
			setup();
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			prepStmt_create = connection.prepareStatement(strPrepSQL_create);
			Date date = new Date(System.currentTimeMillis());;
			prepStmt_create.setString(1, comment.getDate().toString());
			prepStmt_create.setInt(2, comment.getYear());
			prepStmt_create.setString(3, comment.getContent());
			prepStmt_create.setString(4, comment.getUser().getUserID());
			prepStmt_create.setInt(5, comment.getLessonId());
			prepStmt_create.setBoolean(6, comment.getCanShowTeacher());

			prepStmt_create.executeUpdate();

			prepStmt_create.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
