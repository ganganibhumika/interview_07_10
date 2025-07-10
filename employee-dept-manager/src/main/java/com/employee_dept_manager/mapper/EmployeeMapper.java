package com.employee_dept_manager.mapper;

import org.springframework.stereotype.Component;

import com.employee_dept_manager.entity.Department;
import com.employee_dept_manager.entity.Employee;
import com.employee_dept_manager.payloadDTO.EmployeeDTO;

@Component
public class EmployeeMapper {

	public EmployeeDTO toDTO(Employee employee) {
		return new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(), employee.getPosition(),
				employee.getSalary(), employee.getDepartment() != null ? employee.getDepartment().getId() : null);
	}

	public Employee toEntity(EmployeeDTO dto, Department dept) {
		Employee emp = new Employee();
		emp.setName(dto.getName());
		emp.setEmail(dto.getEmail());
		emp.setPosition(dto.getPosition());
		emp.setSalary(dto.getSalary());
		emp.setDepartment(dept);
		return emp;
	}
}
