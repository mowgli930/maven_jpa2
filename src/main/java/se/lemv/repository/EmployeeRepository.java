package se.lemv.repository;

import java.util.Collection;

import javax.persistence.PersistenceException;

import se.lemv.entities.Employee;
import se.lemv.exceptions.RepositoryException;

public class EmployeeRepository extends BaseCRUDRepository {

	public Employee getEntity(Long id) throws RepositoryException {
		try{
			manager = getManager();
			return manager.find(Employee.class, id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new RepositoryException("Could not get entity with id: " + id);
		} finally {
			manager.close();
		}
	}
	
	public Collection<Employee> getEmployeesByDepartment(Long departmentId) throws RepositoryException {
		try{
			manager = getManager();
			return manager.createQuery("SELECT e FROM Employee e JOIN FETCH e.departments WHERE d.id = :id", Employee.class)
					.setParameter("id", departmentId).getResultList();
		} catch (PersistenceException e) {
			throw new RepositoryException("Could not get Employee by Department id: " + departmentId, e);
		} finally {
			manager.close();
		}
	}
}
