package com.employee_dept_manager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employee_dept_manager.mapper.DepartmentMapper;
import com.employee_dept_manager.payloadDTO.DepartmentDTO;
import com.employee_dept_manager.payloadDTO.ResponseWrapperDTO;
import com.employee_dept_manager.repository.DepartmentRepository;
import com.employee_dept_manager.utils.VariablesUtils;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public ResponseWrapperDTO getAllDepartments() {

		List<DepartmentDTO> ListOfEmployee = departmentRepository.findAll().stream().map(departmentMapper::toDTO)
				.collect(Collectors.toList());

		return new ResponseWrapperDTO(HttpStatus.OK, VariablesUtils.GET_DATA_SUCCESSFULLY, null, ListOfEmployee);

	}

}
