package com.ex.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ex.dto.DepartmentDTO;
import com.ex.dto.EmployeeDTO;
import com.ex.mapper.EmployeeMapper;
import com.ex.model.Address;
import com.ex.model.Department;
import com.ex.model.Employee;
import com.ex.respository.DepartmentRepository;
import com.ex.respository.EmployeeRepository;

@Service
public class AdminService {

	 private final DepartmentRepository departmentRepository;
	 private final EmployeeRepository employeeRepository;
	 
	 public AdminService(DepartmentRepository departmentRepository,EmployeeRepository employeeRepository) {
		 this.departmentRepository = departmentRepository;
		 this.employeeRepository = employeeRepository;
	 }
	 

	 // add new Employee
	 public EmployeeDTO createEmployee(EmployeeDTO dto) {
	        Employee employee = EmployeeMapper.toSave(dto);
	        Employee saved = employeeRepository.save(employee);
	        return EmployeeMapper.toDTO(saved);
	    }
	 
	 //create new department
	 public ResponseEntity<Department> createDepartment(Department department) {
		 Department savedDepartment = departmentRepository.save(department);
		 return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
	    }
	 
	 
	//assign the department to employee
	 public ResponseEntity<EmployeeDTO> assignDepartments(Long emp_id, List<Long> dept_id) {

		    Employee emp = employeeRepository.findById(emp_id)
		            .orElseThrow(() -> new RuntimeException("Employee Not found"));

		    Set<Department> departments = new HashSet<>(departmentRepository.findAllById(dept_id));

		    emp.getDepartments().addAll(departments);

		    Employee updatedEmployee = employeeRepository.save(emp);

		    EmployeeDTO dto = EmployeeMapper.toDTO(updatedEmployee);

		    return ResponseEntity.ok(dto);
		}


	//find employee by id
	public Employee findEmployeeByName(String emp_name) {
		
		return employeeRepository.findEmployeeByName(emp_name)
                .orElseThrow(() -> new RuntimeException("Employee Not found"));
	}

	
	//find employee by department 
	public List<EmployeeDTO> findEmployeeByDept(String dept_name) {
		List<Employee> employees = employeeRepository.findEmployeesByDepartmentName(dept_name);
		if (employees.isEmpty()) {
		    throw new RuntimeException("Department not found ");
		}
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();

		for (Employee employee : employees) {
		    EmployeeDTO dto = EmployeeMapper.toDTO(employee);
		    employeeDTOs.add(dto);
		}

		return employeeDTOs;

	}
	
	

}
