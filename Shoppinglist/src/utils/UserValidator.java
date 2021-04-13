package utils;

public class UserValidator {
	
	public static boolean validUsername(String username) {
		return username != null && username.matches("^[0-9a-zæøåA-ZÆØÅ]{3,20}$");
	}
	
	public static boolean validPassword(String password) {
		
		boolean isValid = password != null && password.matches("^[0-9a-zæøåA-ZÆØÅ]{8,64}$");
		
		for(int i = 2; i < password.length(); i++) {
			char previous1 = password.charAt(i - 1);
			char previous2 = password.charAt(i - 2);

			if(previous1 == previous2 && previous1 == password.charAt(i)) {
				return false;
			}
		}
		
		return isValid;
		
	}

}
