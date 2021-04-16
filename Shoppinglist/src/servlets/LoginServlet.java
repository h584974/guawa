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
import static utils.UserUtils.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDAO userDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logout(request);
		
		String rememberedEmail = getRememberedUserEmail(request);
		User rememberedUser = rememberedEmail == null ? null : userDAO.findUserByEmail(rememberedEmail);
		
		if(rememberedUser != null) {
			login(request, rememberedUser);
			response.sendRedirect("menu");
		}
		else {
			request.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(request, response);;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		User user = email == null ? null : userDAO.findUserByEmail(email);
		String message = "?m=";
		
		if(user != null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
				
				if(remember != null && !remember.isBlank())
					rememberUser(response, email);
				
				login(request, user);
				response.sendRedirect("menu");
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
