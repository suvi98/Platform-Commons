package com.ex.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ex.dto.DepartmentDTO;
import com.ex.dto.EmployeeDTO;
import com.ex.model.Department;
import com.ex.model.Employee;

public class DepartmentMapper {


	  public DepartmentDTO toDTO(Department department) {
		    DepartmentDTO dto = new DepartmentDTO();
		    dto.setId(department.getId());
		    dto.setName(department.getName());
		    dto.setDescription(department.getDescription());
		    dto.setType(department.getType());
		    
		    List<String> employeeNames = department.getEmployees().stream()
		        .map(Employee::getName) 
		        .collect(Collectors.toList());
		   // dto.setEmployees(employeeNames);

		    dto.setEmployees(employeeNames);
		    return dto;
		}

}
