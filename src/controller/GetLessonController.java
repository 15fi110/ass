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
 * Servlet implementation class GetLessonController
 */
@WebServlet({"/GetLessonController", "/Lesson"} )
public class GetLessonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLessonController() {
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
		HttpSession session = request.getSession();

		if(session.getAttribute("user") == null){
			// ログインしていない場合はlogin.jspへ
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		BaseUser user = (BaseUser)session.getAttribute("user");

		ArrayList<Lesson> resultList = Lesson.getLessonListByUserId(user.getId());

		ServletContext ctx = super.getServletContext();

		ctx.setAttribute("lessonList", resultList);
		response.getWriter().append("Served at: ").append(request.getContextPath());

		BaseUser user = new BaseUser();

		int lessonId = Integer.parseInt(request.getParameter("id"));
		BaseUser result = null;
		result = user.login();

		HttpSession session = request.getSession();
		session.setAttribute("user", result);
		if (result != null) {
			// ログインに成功している場合はmember.jspへ
			System.out.println(result);
			session.setAttribute("user", result);
			if(user.getType() == UserType.ADMINISTRATOR){
				getServletContext().getRequestDispatcher("/adminindex.jsp").forward(request, response);
				return;
			}
			System.out.println(result.getId());
			ArrayList<Lesson> resultList = Lesson.getLessonListByUserId(result.getId());

			ServletContext ctx = super.getServletContext();
			for(Lesson lesson : resultList){
				System.out.println(lesson.getName());
			}
			ctx.setAttribute("lessonList", resultList);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			// ログインに失敗している場合はlogin.jspへ
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
