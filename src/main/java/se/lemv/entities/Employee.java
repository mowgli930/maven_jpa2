package se.lemv.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
Employee
	- id 		 	: Long	  	: primary key
	- firstName 	: String	: not null
	- lastName 	 	: String	: not null
	- employeeNumber: String	: not null

	- Department 	 : En Employee ska kunna tillhöra en Department	
	- ParkingSpot	 : En Employee ska kunna ha en ParkingSpot
 */
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String employeeNumber;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Department> departments;
	
	@Embedded
	private ParkingSpot parkingSpace;
	
	protected Employee() {}

	public Employee(String firstName, String lastName, String employeeNumber, Collection<Department> departments, ParkingSpot parkingSpace) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.departments = departments;
		this.parkingSpace = parkingSpace;
	}
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public Collection<Department> getDepartments() {
		return departments;
	}

	public ParkingSpot getParkingSpace() {
		return parkingSpace;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
	
}
