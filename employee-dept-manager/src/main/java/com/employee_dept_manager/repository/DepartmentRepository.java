package com.employee_dept_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_dept_manager.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{

}
