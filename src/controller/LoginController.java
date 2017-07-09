package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BaseUser;
import model.BaseUser.UserType;

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
		if (result != null) {
			// ログインに成功している場合はmember.jspへ
			session.setAttribute("user", result);
			if(user.getType() == UserType.ADMINISTRATOR){
				getServletContext().getRequestDispatcher("/adminindex.jsp").forward(request, response);
				return;
			}
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			// ログインに失敗している場合はlogin.jspへ
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
