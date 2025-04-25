package com.ex.respository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ex.dto.EmployeeDTO;
import com.ex.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	 List<Employee> findByDepartmentsId(Long departmentId);

	EmployeeDTO save(EmployeeDTO dto);

	@Query("SELECT e FROM Employee e JOIN e.departments d WHERE d.name = :deptName")
	List<Employee> findEmployeesByDepartmentName(@Param("deptName") String deptName);

	@Query("SELECT e FROM Employee e WHERE e.name = :emp_name")
	Optional<Employee> findEmployeeByName(@Param("emp_name") String emp_name);

}
