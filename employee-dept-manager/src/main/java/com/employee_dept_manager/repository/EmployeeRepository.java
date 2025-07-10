package com.employee_dept_manager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_dept_manager.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Optional<Employee> findByEmail(String email);

	Optional<Employee> findByIdAndDepartmentId(String employeeId, String deptId);

	List<Employee> findByDepartmentId(String deptId);
}
