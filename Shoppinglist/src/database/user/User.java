package database.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import utils.BCrypt;

@Entity(name = "User")
@Table(schema = "guawa", name = "g_user")
public class User {
	
	@Id
	private String email;
	private String name;
	private String password;
	
	public User() {}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
