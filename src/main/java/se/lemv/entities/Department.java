package se.lemv.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
/**
Department
	- id 	: Long 	 : primary key
	- name 	: String : not null	
 * @author leo
 */
@Entity
public class Department {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
	Collection<Employee> employees;
	
	protected Department() {}
	
	public Department(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Collection<Employee> getEmployees() {
		return employees;
	}
}
