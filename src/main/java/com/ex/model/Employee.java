package com.ex.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

@Entity
public class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column
	    private String name;
	    @Column
	    private LocalDate dateOfBirth;
	    @Column
	    private String gender;
	    @Column
	    private String employeeCode;
	    
	    @Column
	    private String email;
	    @Column
	    private String mobileNumber;
	    @Column
	    private String emergencyContact;

	    
	    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Address> addresses;

	    
	    
	    @ManyToMany(cascade = CascadeType.ALL) 
	    @JoinTable(
	        name = "employee_department",
	        joinColumns = @JoinColumn(name = "employee_id"),
	        inverseJoinColumns = @JoinColumn(name = "department_id")
	    )
	    private Set<Department> departments = new HashSet<>();

	    
	    


		public Employee() {
			super();
			// TODO Auto-generated constructor stub
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



		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}



		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}



		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public String getEmployeeCode() {
			return employeeCode;
		}



		public void setEmployeeCode(String employeeCode) {
			this.employeeCode = employeeCode;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getMobileNumber() {
			return mobileNumber;
		}



		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}



		public String getEmergencyContact() {
			return emergencyContact;
		}



		public void setEmergencyContact(String emergencyContact) {
			this.emergencyContact = emergencyContact;
		}



		public List<Address> getAddresses() {
			return addresses;
		}



		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}



		public Set<Department> getDepartments() {
			return departments;
		}



		public void setDepartments(Set<Department> departments) {
			this.departments = departments;
		}

	    
	    
	      
	    
	}
