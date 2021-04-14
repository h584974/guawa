package database.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDAO {
	
	@PersistenceContext(name = "guawaPU")
	EntityManager em;
	
	public User findUserByEmail(String email) {
		return em.find(User.class, email);
	}
	
	public void addUser(User user) {
		em.persist(user);
	}
	
	public void removeUser(User user) {
		User u = em.merge(user);
		em.remove(u);
	}

}
