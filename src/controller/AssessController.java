package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Assessment;
import model.AssessmentComment;
import model.AssessmentCommentDAO;
import model.AssessmentDAO;
import model.BaseUser;
import model.Lesson;
import model.Student;

/**
 * Servlet implementation class AssessController
 */
@WebServlet({"/AssessController", "/Assess"})
public class AssessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssessController() {
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

		ServletContext ctx = super.getServletContext();

		Lesson lesson = (Lesson) ctx.getAttribute("lesson");

		System.out.println(request.getParameterMap());

		Assessment assessment = new Assessment();
		assessment.setItem1(Integer.parseInt(request.getParameter("item1")));
		assessment.setItem2(Integer.parseInt(request.getParameter("item2")));
		assessment.setItem3(Integer.parseInt(request.getParameter("item3")));
		assessment.setItem4(Integer.parseInt(request.getParameter("item4")));
		assessment.setItem5(Integer.parseInt(request.getParameter("item5")));
		assessment.setItem6(Integer.parseInt(request.getParameter("item6")));
		assessment.setItem7(Integer.parseInt(request.getParameter("item7")));
		assessment.setItem8(Integer.parseInt(request.getParameter("item8")));
		assessment.setItem9(Integer.parseInt(request.getParameter("item9")));
		assessment.setItem10(Integer.parseInt(request.getParameter("item10")));
		assessment.setItem11(Integer.parseInt(request.getParameter("item11")));
		assessment.setItem12(Integer.parseInt(request.getParameter("item12")));
		assessment.setItem13(Integer.parseInt(request.getParameter("item13")));
		assessment.setLessonId(lesson.getId());
		assessment.setStudent((Student)user);
		assessment.setUpDate();

		AssessmentDAO assessmentDAO = new AssessmentDAO();
		assessmentDAO.create(assessment);

		AssessmentComment comment = new AssessmentComment();
		comment.setContent(request.getParameter("comment"));
		comment.setStudent((Student)user);
		comment.setLesson(lesson);
		comment.setUpDate();

		AssessmentCommentDAO assessmentCommentDAO = new AssessmentCommentDAO();
		assessmentCommentDAO.create(comment);

		getServletContext().getRequestDispatcher("/individual.jsp").forward(request, response);
	}

}