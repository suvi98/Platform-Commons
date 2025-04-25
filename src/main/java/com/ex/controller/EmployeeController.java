package com.ex.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.dto.DepartmentDTO;
import com.ex.dto.EmployeeDTO;
import com.ex.mapper.EmployeeMapper;
//import com.ex.dto.EmployeeDTO;
import com.ex.model.Employee;
import com.ex.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@GetMapping("/print")
	public String print() {
		
		return "hello";
	}
	
	
	//Employees can update their profile details,
	@PutMapping("/updateEmployee/{empId}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long empId, @RequestBody EmployeeDTO dto) {
	    Employee updated = employeeService.updateEmployeeProfile(empId, dto);
	    return ResponseEntity.ok(EmployeeMapper.toDTO(updated));
	}

	//find department by employee ID
	@GetMapping("/employee/{empId}/departments")
	public ResponseEntity<List<DepartmentDTO>> getDepartmentsByEmployee(@PathVariable Long empId) {
	    List<DepartmentDTO> departments = employeeService.getDepartmentsByEmployee(empId);
	    return ResponseEntity.ok(departments);
	}

	
	//delete department by departmentId
	@DeleteMapping("/{empId}/dateleDepartment/{deptId}")
	public ResponseEntity<String> dateleDepartment(@PathVariable Long empId,@PathVariable Long deptId){
		
		employeeService.deleteDeptById(empId,deptId);
		return ResponseEntity.ok("Department delete Successfully..");
	}
}
