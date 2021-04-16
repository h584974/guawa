package servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.user.User;
import database.user.UserDAO;
import static utils.UserUtils.*;
import database.shoppinglist.Shoppinglist;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDAO userDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(isLoggedIn(request)) {
			User user = getLoggedInUser(request);
			List<Shoppinglist> ownedShoppinglists = user == null ? null : user.getOwnedShoppinglists();
			
			request.setAttribute("ownedShoppinglists", ownedShoppinglists);
			request.getRequestDispatcher("WEB-INF/JSP/menu.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("login");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
