package se.lemv.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import se.lemv.exceptions.RepositoryException;

public class BaseCRUDRepository {
	
	private static final EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory("PersistenceUnit");
	protected EntityManager manager;
	
	protected EntityManager getManager() {
		return FACTORY.createEntityManager();
	}

	public void saveEntity(Object entity) throws RepositoryException {
		try {
			manager = getManager();
			manager.getTransaction().begin();
			manager.persist(entity);
			manager.getTransaction().commit();
		} catch(PersistenceException e) {
			manager.getTransaction();
			e.printStackTrace();
			throw new RepositoryException("Could not save entity: " + entity.toString());
		} finally {
			manager.close();
		}
	}

}
