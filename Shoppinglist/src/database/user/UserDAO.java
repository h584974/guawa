package database.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDAO {
	
	@PersistenceContext(name = "guawaPU")
	EntityManager em;
	
	public User findUserByUsername(String username) {
		return em.find(User.class, username);
	}
	
	public void addUser(User user) {
		em.persist(user);
	}
	
	public void removeUser(User user) {
		User u = em.merge(user);
		em.remove(u);
	}

}
