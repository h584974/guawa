package database.shoppinglist;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import database.user.User;

@Entity(name = "Shoppinglist")
@Table(schema = "guawa", name = "shoppinglist")
public class Shoppinglist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "owner", referencedColumnName = "email")
	private User owner;
	
	private LocalDate creation_date;
	private String title;
	
	public Shoppinglist() {}
	
	public Shoppinglist(User owner, String title) {
		this.owner = owner;
		this.title = title;
		this.creation_date = LocalDate.now();
	}

	public long getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public String getTitle() {
		return title;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
