package servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.user.User;
import database.user.UserDAO;
import utils.BCrypt;
import utils.UserUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDAO userDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(UserUtils.isLoggedIn(request)) {
			response.sendRedirect("main-page");
		}
		else {
			request.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(request, response);;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("username");
		
		User user = username == null ? null : userDAO.findUserByUsername(username);
		String message = "?m=";
		
		if(user != null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
				UserUtils.login(response, username);
				response.sendRedirect("main-page");
			}
			else {
				message += messages.LoginMessages.LOGIN_ERROR_PASSWORD;
				response.sendRedirect("login" + message);
			}
		}
		else {
			message += messages.LoginMessages.LOGIN_ERROR_USER_NOT_FOUND;
			response.sendRedirect("login" + message);
		}
		
	}

}
