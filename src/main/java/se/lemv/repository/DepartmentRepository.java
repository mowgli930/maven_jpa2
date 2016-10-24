package se.lemv.repository;

import java.util.Collection;

import javax.persistence.PersistenceException;

import se.lemv.entities.Department;
import se.lemv.exceptions.RepositoryException;

public class DepartmentRepository extends BaseCRUDRepository {

	public Department getEntity(Long departmentId) throws RepositoryException {
		try{
			manager = getManager();
			return manager.find(Department.class, departmentId);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new RepositoryException("Could not get entity with id: " + departmentId);
		} finally {
			manager.close();
		}
	}
	
	public Collection<Department> getDepartmentsByEmployeeId(Long employeeId) throws RepositoryException {
		try{
			manager = getManager();
			return manager.createQuery("SELECT d FROM Department d JOIN FETCH d.employees e WHERE e.id = :id", Department.class)
					.setParameter("id", employeeId).getResultList();
		} catch(PersistenceException e) {
			throw new RepositoryException("Could not get Departments by Employee id: " + employeeId, e);
		} finally {
			manager.close();
		}
	}
}
