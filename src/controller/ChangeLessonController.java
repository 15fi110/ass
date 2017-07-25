package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lesson;

/**
 * Servlet implementation class ChangeLessonController
 */
@WebServlet({"/ChangeLessonController", "/Change"})
public class ChangeLessonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeLessonController() {
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

		int lessonId = Integer.parseInt(request.getParameter("id"));
		boolean isShowing = Boolean.parseBoolean(request.getParameter("isShowing"));

		Lesson.changeShowing(lessonId, isShowing);

		getServletContext().getRequestDispatcher("/adminIndex.jsp").forward(request, response);
	}

}