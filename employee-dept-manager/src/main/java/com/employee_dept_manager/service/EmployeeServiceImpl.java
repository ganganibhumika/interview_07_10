package com.employee_dept_manager.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employee_dept_manager.entity.Department;
import com.employee_dept_manager.entity.Employee;
import com.employee_dept_manager.mapper.EmployeeMapper;
import com.employee_dept_manager.payloadDTO.EmployeeDTO;
import com.employee_dept_manager.payloadDTO.ResponseWrapperDTO;
import com.employee_dept_manager.repository.DepartmentRepository;
import com.employee_dept_manager.repository.EmployeeRepository;
import com.employee_dept_manager.utils.VariablesUtils;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private EmployeeMapper employeeMapper;
    
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
    @Transactional
	public ResponseWrapperDTO addEmployeeToDepartment(String deptId, EmployeeDTO employeeDto) {
		try {
			LOGGER.info("start  addEmployee service:: {}", employeeDto);
			LOGGER.info("Check employee already exist or not by email!");

			Optional<Employee> employeeByEmail = employeeRepository.findByEmail(employeeDto.getEmail());
			Department department = departmentRepository.findById(deptId)
					.orElseThrow(() -> new RuntimeException("Department not found"));
			if (employeeByEmail.isPresent()) {
				return new ResponseWrapperDTO(HttpStatus.CONFLICT, VariablesUtils.DATA_ALREADY_EXIST,
						"Emaployee email " + VariablesUtils.DATA_ALREADY_EXIST, null);
			}

			Employee employee = employeeMapper.toEntity(employeeDto, department);

			employeeRepository.save(employee);

		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("exit addEmployee.");
		return new ResponseWrapperDTO(HttpStatus.OK, "Employee " + VariablesUtils.SAVE_DATA_SUCCESSFULLY, null, null);
	}

	@Override
    @Transactional
	public ResponseWrapperDTO deleteEmployeeByDepartmentId(String employeeId, String deptId) {
		LOGGER.info("Start deleteEmployeeByDepartmentId.");
		 Employee employee = employeeRepository.findByIdAndDepartmentId(employeeId, deptId)
	                .orElseThrow(() -> new RuntimeException("Employee not found in department"));
    	employeeRepository.delete(employee);
		LOGGER.info("Exit deleteEmployeeById.");
		return new ResponseWrapperDTO(HttpStatus.OK, "Employee " + VariablesUtils.DELETE_DATA_SUCCESSFULLY, null, null);

	}

	@Override
	public ResponseWrapperDTO getAllEmployees() {

		List<EmployeeDTO> ListOfEmployee = employeeRepository.findAll().stream().map(employeeMapper::toDTO)
				.collect(Collectors.toList());

		return new ResponseWrapperDTO(HttpStatus.OK, VariablesUtils.GET_DATA_SUCCESSFULLY, null, ListOfEmployee);
	}

	@Override
	public ResponseWrapperDTO getEmployeesByDepartment(String deptId) {

		List<EmployeeDTO> employeeList = employeeRepository.findByDepartmentId(deptId).stream()
				.map(employeeMapper::toDTO).collect(Collectors.toList());
		LOGGER.info("EmployeeList::"+employeeList.size());
		return new ResponseWrapperDTO(HttpStatus.OK, VariablesUtils.GET_DATA_SUCCESSFULLY, null, employeeList);
	}

}
