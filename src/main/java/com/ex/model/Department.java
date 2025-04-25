package com.ex.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Department {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String name;
	    @Column
	    private String description;
	    @Column
	    private String type;
	    @Column
	    private int numberOfEmployees;
	    @Column
	    private String responsibilities;
	
	    @ManyToMany(mappedBy = "departments") 
	    private Set<Employee> employees = new HashSet<>();
	    
	    
	    

		public Department() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Department [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
					+ ", numberOfEmployees=" + numberOfEmployees + ", responsibilities=" + responsibilities
					+ ", employees=" + employees + "]";
		}

		public Department(Long id, String name, String description, String type, int numberOfEmployees,
				String responsibilities, Set<Employee> employees) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.type = type;
			this.numberOfEmployees = numberOfEmployees;
			this.responsibilities = responsibilities;
			this.employees = employees;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getNumberOfEmployees() {
			return numberOfEmployees;
		}

		public void setNumberOfEmployees(int numberOfEmployees) {
			this.numberOfEmployees = numberOfEmployees;
		}

		public String getResponsibilities() {
			return responsibilities;
		}

		public void setResponsibilities(String responsibilities) {
			this.responsibilities = responsibilities;
		}

		public Set<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> list) {
			this.employees = (Set<Employee>) list;
		}
	    
	    
	    
	    
	}