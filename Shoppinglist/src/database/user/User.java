package database.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import database.shoppinglist.Shoppinglist;
import utils.BCrypt;

@Entity(name = "User")
@Table(schema = "guawa", name = "g_user")
public class User {
	
	@Id
	private String email;
	private String name;
	private String password;
	
	@OneToMany(mappedBy = "owner")
	private List<Shoppinglist> owned_shoppinglists;
	
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
	
	public List<Shoppinglist> getOwnedShoppinglists() {
		return owned_shoppinglists;
	}

}
