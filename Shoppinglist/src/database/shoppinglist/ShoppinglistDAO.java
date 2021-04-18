package database.shoppinglist;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import database.user.User;

@Stateless
public class ShoppinglistDAO {
	
	@PersistenceContext(name = "guawaPU")
	EntityManager em;
	
	public Shoppinglist findShoppinglistById(long id) {
		return em.find(Shoppinglist.class, id);
	}
	
	public List<Shoppinglist> getOwnedShoppinglistsFromUser(User user) {
		
		String email = user == null ? "" : user.getEmail();
		String jpql = "SELECT s FROM Shoppinglist s";
		return em.createQuery(jpql, Shoppinglist.class).getResultList();
		
	}

}
