package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BaseUser;
import model.BaseUser.UserType;
import model.Lesson;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({"/LoginController", "/Login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BaseUser user = new BaseUser();

		user.setUserID(request.getParameter("userID"));
		user.setPassword(request.getParameter("password"));

		BaseUser result = null;
		result = user.login();

		HttpSession session = request.getSession();
		session.setAttribute("user", result);
		ServletContext ctx = super.getServletContext();
		if (result != null) {
			// ログインに成功している場合はmember.jspへ
			System.out.println(result);
			session.setAttribute("user", result);

			ArrayList<Lesson> resultList = null;
			switch(result.getType()){
			case STUDENT:
				resultList = Lesson.getLessonListByUserId(result.getId());
				break;
			case TEACHER:
				resultList = Lesson.getLessonListByTeacherId(result.getId());
				break;
			case ADMINISTRATOR:
				resultList = Lesson.getLessonListByAdministrator();
				break;
			}

			ctx.setAttribute("lessonList", resultList);
			ctx.setAttribute("user", user);
			ctx.setAttribute("loginFailed", false);

			if(result.getType() == UserType.ADMINISTRATOR){
				getServletContext().getRequestDispatcher("/adminIndex.jsp").forward(request, response);
				return;
			}
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			// ログインに失敗している場合はlogin.jspへ
			ctx.setAttribute("loginFailed", true);
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
