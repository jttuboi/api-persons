package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	public EntityManager em;
	public EntityManagerFactory emf;
	
	public void open() {
		emf = Persistence.createEntityManagerFactory("apiPersonsPersistence");
		em = emf.createEntityManager();
	}
	
	public void close() {
		em.close();
		emf.close();
	}
}
