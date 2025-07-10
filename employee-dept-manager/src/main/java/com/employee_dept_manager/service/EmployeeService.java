package com.employee_dept_manager.service;

import com.employee_dept_manager.payloadDTO.EmployeeDTO;
import com.employee_dept_manager.payloadDTO.ResponseWrapperDTO;

public interface EmployeeService {

	/***
	 * d. Add new employee in a department
	 * 
	 * @author Bhumika 
	 * @param deptId and Object of employee
	 * @exception employee already exist
	 */
	
	ResponseWrapperDTO addEmployeeToDepartment(String deptId, EmployeeDTO  employeeDto) throws Exception;

	/***
	 * e. Delete an employee in a department
	 * Delete employee based on department Id
	 * @author Bhumika 
	 * @param employeeId , departmentID
	 * @exception employeeId Not found
	 */
	
	ResponseWrapperDTO deleteEmployeeByDepartmentId(String employeeId, String departmentId) throws Exception;

	/***
	 *  a. Get all employees
	 *  
	 * Get All exist employee in database
	 * @author Bhumika 
	 */
	ResponseWrapperDTO getAllEmployees();

	
	
	/***
	 *   c. Get all employees in a specific department
	 *  
	 * @author Bhumika 
	 */
	ResponseWrapperDTO getEmployeesByDepartment(String deptId);
}
