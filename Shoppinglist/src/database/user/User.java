package database.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import utils.BCrypt;

@Entity
@Table(schema = "guawa", name = "g_user")
public class User {
	
	@Id
	private String username;
	private String password;
	
	public User() {}
	
	public User(String username, String password) {
		this.username = username;
		this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
