package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Assessment;
import model.AssessmentComment;

/**
 * Servlet implementation class AssessConfirmController
 */
@WebServlet({"/AssessConfirmController", "/Confirm"})
public class AssessConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssessConfirmController() {
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
		ServletContext ctx = super.getServletContext();

		Assessment assessment = (Assessment)ctx.getAttribute("assessment");
		assessment.register();

		AssessmentComment comment = (AssessmentComment)ctx.getAttribute("assessmentComment");
		comment.register();

		getServletContext().getRequestDispatcher("/individual.jsp").forward(request, response);
	}

}
