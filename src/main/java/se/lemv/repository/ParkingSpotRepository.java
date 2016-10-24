package se.lemv.repository;

import javax.persistence.PersistenceException;

import se.lemv.entities.ParkingSpot;
import se.lemv.exceptions.RepositoryException;

public class ParkingSpotRepository extends BaseCRUDRepository {

	public ParkingSpot getEntity(Long id) throws RepositoryException {
		try{
			manager = getManager();
			return manager.find(ParkingSpot.class, id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new RepositoryException("Could not get entity with id: " + id);
		} finally {
			manager.close();
		}
	}
}
