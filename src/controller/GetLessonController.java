package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BaseUser;
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

		int lessonId = Integer.parseInt(request.getParameter("userID"));

		Lesson result = Lesson.getLessonById(lessonId);

		ServletContext ctx = super.getServletContext();

		ctx.setAttribute("lesson", result);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
