package com.employee_dept_manager.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_dept_manager.payloadDTO.EmployeeDTO;
import com.employee_dept_manager.payloadDTO.ResponseWrapperDTO;
import com.employee_dept_manager.service.EmployeeService;
import com.employee_dept_manager.utils.MethodsUtils;
import com.employee_dept_manager.utils.VariablesUtils;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);


		@GetMapping
		public ResponseEntity<ResponseWrapperDTO> getAllEmployees(HttpServletRequest request) {
			try {
				LOGGER.info("start getAllEmployees");
				// enhancement - check for valid access
				return new ResponseEntity<ResponseWrapperDTO>(employeeService.getAllEmployees(), HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ResponseWrapperDTO>(
						new ResponseWrapperDTO(HttpStatus.OK, e.getMessage(), null, null), HttpStatus.BAD_REQUEST);
			}
		}
		
	@PostMapping("/addEmployeeToDepartment/")
	public ResponseEntity<ResponseWrapperDTO> addEmployeeToDepartment(@PathVariable String deptId, @RequestBody EmployeeDTO employeeDto, HttpServletRequest request) {
		try {
			LOGGER.info("start addEmployee.");
			if(MethodsUtils.isObjectNullOrEmpty(deptId) && MethodsUtils.isObjectNullOrEmpty(employeeDto)) {
				return ResponseEntity.badRequest().body(new ResponseWrapperDTO(HttpStatus.BAD_REQUEST,
						"Please provide valid employee details!", null, null));
			}
			return new ResponseEntity<ResponseWrapperDTO>(employeeService.addEmployeeToDepartment(deptId,employeeDto), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseWrapperDTO>(
					new ResponseWrapperDTO(HttpStatus.OK,  "Something went wrong while adding employee: " + e.getMessage(), null, null), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/deleteEmployeeFromDepartment/{empId}")
	public ResponseEntity<ResponseWrapperDTO> deleteEmployeeFromDepartment(@PathVariable String empId,
            @PathVariable String deptId,
			HttpServletRequest request) {
		try {
			LOGGER.info("start deleteEmployeeFromDepartment." + empId);
			if (MethodsUtils.isObjectNullOrEmpty(empId) && MethodsUtils.isObjectNullOrEmpty(deptId)) {
				return new ResponseEntity<ResponseWrapperDTO>(
						new ResponseWrapperDTO(HttpStatus.OK, VariablesUtils.INCOMPLETE_REQUEST_DATA, null, null),
						HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<ResponseWrapperDTO>(employeeService.deleteEmployeeByDepartmentId(empId,deptId), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseWrapperDTO>(
					new ResponseWrapperDTO(HttpStatus.OK, e.getMessage(), null, null), HttpStatus.BAD_REQUEST);
		}
	}

	
    @GetMapping("/getEmployeesByDepartment/{deptId}")
    public ResponseEntity<ResponseWrapperDTO> getEmployeesByDepartment(@PathVariable String deptId) {
        try {
        	LOGGER.info("start getEmployeesByDepartment deptId:" + deptId);
			if (MethodsUtils.isObjectNullOrEmpty(deptId)) {
				return new ResponseEntity<ResponseWrapperDTO>(
						new ResponseWrapperDTO(HttpStatus.OK, VariablesUtils.INCOMPLETE_REQUEST_DATA, null, null),
						HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<ResponseWrapperDTO>(employeeService.getEmployeesByDepartment(deptId), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseWrapperDTO>(
					new ResponseWrapperDTO(HttpStatus.OK, e.getMessage(), null, null), HttpStatus.BAD_REQUEST);
		}
    }
    

}
