package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetLessonListController
 */
@WebServlet({"/GetLessonListController", "/LessonList"})
public class GetLessonListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLessonListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if(session.getAttribute("user") == null){
			// ログインしていない場合はlogin.jspへ
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
//		BaseUser user = (BaseUser)session.getAttribute("user");
//
//		ArrayList<Lesson> resultList = Lesson.getLessonListByUserId(user.getId());
//
//		ServletContext ctx = super.getServletContext();
//
//		ctx.setAttribute("lessonList", resultList);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}