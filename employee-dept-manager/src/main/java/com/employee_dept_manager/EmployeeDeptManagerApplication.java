package com.employee_dept_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EmployeeDeptManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDeptManagerApplication.class, args);
	}


	@GetMapping("/")
	public String testApplication() {
		return "Welcome to employee-dept-manager !";
	}
}
