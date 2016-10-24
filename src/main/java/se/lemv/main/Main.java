package se.lemv.main;

import java.util.Arrays;
import java.util.Collection;

import se.lemv.entities.Department;
import se.lemv.entities.Employee;
import se.lemv.entities.ParkingSpot;
import se.lemv.exceptions.RepositoryException;
import se.lemv.repository.DepartmentRepository;
import se.lemv.repository.EmployeeRepository;

public class Main {
	
	
	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new EmployeeRepository();
		DepartmentRepository departmentRepository = new DepartmentRepository();
		
		ParkingSpot parkingSpace1 = new ParkingSpot(10L, "parking label?");
		ParkingSpot parkingSpace2 = new ParkingSpot(11L, "parking label?");
		
		Department department1 = new Department("Department of magic");
		Department department2 = new Department("Department of Mystery");
		
		try {
			departmentRepository.saveEntity(department1);
			departmentRepository.saveEntity(department2);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		Collection<Department> departments = Arrays.asList(department1, department2);
		
		Employee employee1 = new Employee("Analking", "Skywalker", "420", departments, parkingSpace1);
		Employee employee2 = new Employee("Analking", "Skywalker", "420", departments, parkingSpace2);
		
		try {
			employeeRepository.saveEntity(employee1);
			employeeRepository.saveEntity(employee2);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
		Employee employee = null;
		try {
			employee = (Employee) employeeRepository.getEntity(employee1.getId());
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(employee != null)
			employee.getDepartments().forEach(System.out::println);
		
		try {
			departmentRepository.getDepartmentsByEmployeeId(employee1.getId()).forEach(System.out::println);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
}
