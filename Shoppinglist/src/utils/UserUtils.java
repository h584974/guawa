package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUtils {
	
	public static void login(HttpServletResponse response, String username) {
		
		Cookie loginCookie = new Cookie("loginCookie",username);
		loginCookie.setMaxAge(Config.USER_MAX_SECONDS_LOGGED_IN);
		response.addCookie(loginCookie);
		
	}
	
	public static boolean isLoggedIn(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(Cookie c : cookies) {
				if(c != null && c.getName().equals("loginCookie"))
					return true;
			}
			
		}
		
		return false;
		
	}
	
	public static String getLoggedInUsername(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(Cookie c : cookies) {
				if(c != null && c.getName().equals("loginCookie"))
					return c.getValue();
			}
			
		}
		
		return null;
		
	}
	
	public static void logout(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(Cookie c : request.getCookies()) {
				
				if(c.getName().equals("loginCookie")) {
					c.setMaxAge(0);
					response.addCookie(c);
					return;
				}
				
			}
			
		}
		
	}

}
