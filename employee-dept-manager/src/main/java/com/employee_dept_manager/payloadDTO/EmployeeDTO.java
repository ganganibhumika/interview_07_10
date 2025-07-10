package com.employee_dept_manager.payloadDTO;

public class EmployeeDTO {

	private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
    private String departmentId;
    
    public EmployeeDTO() {
    }
    
    public EmployeeDTO(String id, String name, String email, String position, double salary, String departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.departmentId = departmentId;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
    
    
    
}
