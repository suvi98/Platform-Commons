package com.ex.dto;

import java.time.LocalDate;
import java.util.*;

import com.ex.model.Employee;

import jakarta.persistence.Column;

public class EmployeeDTO {

	private Long id;
    private String name;
    private String gender;
    private String employeeCode;
    private LocalDate dateOfBirth;
    private String email;
    private String mobileNumber;
    private String emergencyContact;
    private List<AddressDTO> addresses;
    private List<DepartmentDTO> departments;
    
    
    
	public EmployeeDTO() {
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	public List<DepartmentDTO> getDepartments() {
		return departments;
	}
	public void setDepartments(List<DepartmentDTO> departments) {
		this.departments = departments;
	}
    
    
    
    
    
}
