package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.user.User;

public class UserUtils {
	
	public static void login(HttpServletRequest request, User user) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)
			session.invalidate();
		
		session = request.getSession(true);
		session.setAttribute("user", user);
		
	}
	
	public static void logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null)
			session.invalidate();
		
	}
	
	public static boolean isLoggedIn(HttpServletRequest request) {
		
		return request.getSession() != null && request.getAttribute("user") != null;
		
	}
	
	public static void rememberUser(HttpServletResponse response, String email) {
		
		Cookie cookie = new Cookie("remember",email);
		cookie.setMaxAge(Config.USER_MAX_SECONDS_REMEMBERED);
		response.addCookie(cookie);
		
	}
	
	public static String getRememberedUserEmail(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(Cookie c : cookies) {
				if(c.getName().equals("remember"))
					return c.getValue();
			}
			
		}
		
		return null;
		
	}
	
	public static void forgetUser(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(Cookie c : request.getCookies()) {
				
				if(c.getName().equals("remember")) {
					c.setMaxAge(0);
					response.addCookie(c);
					return;
				}
				
			}
			
		}
		
	}

}
