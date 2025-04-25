package com.ex.dto;

import java.util.List;

import com.ex.model.Employee;

public class DepartmentDTO {

	  private Long id;
	    private String name;
	    private String description;
	    private String type;
	    private int numberOfEmployees;
	    private String responsibilities;
	    private List<String> employees;
	    
	    
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
		public List<String> getEmployees() {
			return employees;
		}
		public void setEmployees(List<String> employeeNames) {
			this.employees = employeeNames;
		}
	    
	    
}
