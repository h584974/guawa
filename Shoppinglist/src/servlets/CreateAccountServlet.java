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
import static utils.UserValidator.*;

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
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password");
		String message = "?m=";
		
		if(!validName(name)) {
			message += CreateUserMessages.INVALID_NAME;
			response.sendRedirect("create-account" + message);
		}
		else if(!validPassword(password)) {
			message += CreateUserMessages.INVALID_PASSWORD;
			response.sendRedirect("create-account" + message);
		}
		else if(!password.equals(password2)) {
			message += CreateUserMessages.PASSWORDS_DO_NOT_MATCH;
			response.sendRedirect("create-account" + message);
		}
		else {
			
			User user = userDAO.findUserByEmail(email);
			
			if(user != null) {
				message += CreateUserMessages.EMAIL_USED;
				response.sendRedirect("create-account" + message);
			}
			else {
				User newUser = new User(email,name,password);
				userDAO.addUser(newUser);
				message += CreateUserMessages.USER_CREATED;
				response.sendRedirect("login" + message);
			}
			
		}
		
	}

}
