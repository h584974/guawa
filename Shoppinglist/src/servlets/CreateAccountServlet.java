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
import messages.CreateUserMessages;
import utils.UserValidator;

@WebServlet("/create-account")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDAO userDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/JSP/create-account.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password");
		String message = "?m=";
		
		if(!UserValidator.validUsername(username)) {
			message += CreateUserMessages.INVALID_USERNAME;
			response.sendRedirect("create-account" + message);
		}
		else if(!UserValidator.validPassword(password)) {
			message += CreateUserMessages.INVALID_PASSWORD;
			response.sendRedirect("create-account" + message);
		}
		else if(!password.equals(password2)) {
			message += CreateUserMessages.PASSWORDS_DO_NOT_MATCH;
			response.sendRedirect("create-account" + message);
		}
		else {
			
			User user = userDAO.findUserByUsername(username);
			
			if(user != null) {
				message += CreateUserMessages.USERNAME_TAKEN;
				response.sendRedirect("create-account" + message);
			}
			else {
				User newUser = new User(username,password);
				userDAO.addUser(newUser);
				message += CreateUserMessages.USER_CREATED;
				response.sendRedirect("login" + message);
			}
			
		}
		
	}

}
