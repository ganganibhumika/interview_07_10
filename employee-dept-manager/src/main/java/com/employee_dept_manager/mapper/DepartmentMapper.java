package com.employee_dept_manager.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee_dept_manager.entity.Department;
import com.employee_dept_manager.payloadDTO.DepartmentDTO;
import com.employee_dept_manager.payloadDTO.EmployeeDTO;

@Component
public class DepartmentMapper {

	@Autowired
	private EmployeeMapper employeeMapper;

	public DepartmentDTO toDTO(Department dept) {
		List<EmployeeDTO> employees = dept.getEmployees().stream().map(employeeMapper::toDTO)
				.collect(Collectors.toList());

		return new DepartmentDTO(dept.getId(), dept.getName(), dept.getLocation(), employees);
	}

}
