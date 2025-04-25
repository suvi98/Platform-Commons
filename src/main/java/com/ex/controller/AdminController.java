package com.ex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.dto.DepartmentDTO;
import com.ex.dto.EmployeeDTO;
import com.ex.mapper.EmployeeMapper;
import com.ex.model.Department;
import com.ex.model.Employee;
import com.ex.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		
		this.adminService =  adminService;
	}
	
	//Admin can add a new employee
	 @PostMapping("/save_emp")
	  public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO dto) {
        EmployeeDTO saved = adminService.createEmployee(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
	
	//Admin can create departments
	@PostMapping("/save_dept")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department dto) {
	 
	    ResponseEntity<Department> savedDepartment = adminService.createDepartment(dto);

	    return savedDepartment;
	}
	
	//Admin can assign one or more departments to employees.
	@PostMapping("/{id}/assign_dept")
	public ResponseEntity<EmployeeDTO> assignDepartment(
									@PathVariable Long id,
									@RequestBody List<Long> dept_id) {
		
		return adminService.assignDepartments(id,dept_id);
	}
	
	//Get employees by name
	@GetMapping("/getEmployeeById/{emp_name}")
	public ResponseEntity<EmployeeDTO> getEmployeeByName(@PathVariable String emp_name) {
		
	    Employee employee = adminService.findEmployeeByName(emp_name);
	    return ResponseEntity.ok(EmployeeMapper.toDTO(employee));
	}
	
	//Get employees assigned to a specific department
	@GetMapping("/getEmployeeByDept/{dept_name}")
	public ResponseEntity<List<EmployeeDTO>> getEmployeeByDept(@PathVariable String dept_name){
		
		List<EmployeeDTO> employee = adminService.findEmployeeByDept(dept_name);
		
		return ResponseEntity.ok(employee);
	}

}
