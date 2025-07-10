package com.employee_dept_manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_dept_manager.payloadDTO.ResponseWrapperDTO;
import com.employee_dept_manager.service.DepartmentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);


		@GetMapping
		public ResponseEntity<ResponseWrapperDTO> getAllDepartments(HttpServletRequest request) {
			try {
				LOGGER.info("start getAllDepartments");
				// enhancement - check for valid access
				return new ResponseEntity<ResponseWrapperDTO>(departmentService.getAllDepartments(), HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ResponseWrapperDTO>(
						new ResponseWrapperDTO(HttpStatus.OK, e.getMessage(), null, null), HttpStatus.BAD_REQUEST);
			}
		}
	
}
