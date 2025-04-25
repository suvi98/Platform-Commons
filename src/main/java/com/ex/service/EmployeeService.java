package com.ex.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ex.dto.DepartmentDTO;
import com.ex.dto.EmployeeDTO;
//import com.ex.dto.AddressDTO;
//import com.ex.dto.EmployeeContactDTO;
//import com.ex.dto.EmployeeDTO;
//import com.ex.mapper.EmployeeMapper;
import com.ex.model.Address;
import com.ex.model.Department;
import com.ex.model.Employee;
import com.ex.respository.DepartmentRepository;
import com.ex.respository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository) {
		
		this.employeeRepository = employeeRepository;
     	this.departmentRepository = departmentRepository;
	}
	

	public List<Employee> fetch(){
		
		return employeeRepository.findAll();
	}
	
	    
	    
	//update the employee
	    public Employee updateEmployeeProfile(Long empId, EmployeeDTO profileDTO) {
	        Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	        employee.setEmail(profileDTO.getEmail());
	        employee.setMobileNumber(profileDTO.getMobileNumber());
	        employee.setEmergencyContact(profileDTO.getEmergencyContact());

	        // Clear old addresses and add new ones
	        if (profileDTO.getAddresses() != null) {
	            List<Address> updatedAddresses = profileDTO.getAddresses().stream().map(a -> {
	                Address address = new Address();
	                address.setType(a.getType());
	                address.setCity(a.getCity());
	                address.setState(a.getState());
	                address.setZip(a.getZip());
	                address.setLine1(a.getLine1());
	                address.setEmployee(employee); // set back-reference
	                return address;
	            }).collect(Collectors.toList());

	            employee.getAddresses().clear();
	            employee.getAddresses().addAll(updatedAddresses);
	        }

	        return employeeRepository.save(employee);
	    }

	    
	    //find employee departments based on employee ID
	    public List<DepartmentDTO> getDepartmentsByEmployee(Long empId) {
	        Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	        return employee.getDepartments().stream().map(department -> {
	            DepartmentDTO dto = new DepartmentDTO();
	            dto.setId(department.getId());
	            dto.setName(department.getName());
	            dto.setType(department.getType());
	            dto.setDescription(department.getDescription());
	            dto.setNumberOfEmployees(department.getNumberOfEmployees());
	            dto.setResponsibilities(department.getResponsibilities());
	            return dto;
	        }).collect(Collectors.toList());
	    }


	    public void deleteDeptById(Long empId, Long deptId) {
	        Employee employee = employeeRepository.findById(empId)
	            .orElseThrow(() -> new RuntimeException("Employee Not Found"));

	        boolean found = false;

	        for (Department dept : employee.getDepartments()) {
	            if (dept.getId().equals(deptId)) {
	                employee.getDepartments().remove(dept);
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            throw new RuntimeException("Department not assigned to employee");
	        }

	        employeeRepository.save(employee);
	    }

}
