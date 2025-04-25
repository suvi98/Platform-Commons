package com.ex.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
