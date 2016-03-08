


package com.training.resources;

public class Employee {

	private String employeeId;
	private String employeeName;
	
	public Employee(String employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	String getEmployeeId() {
		return employeeId;
	}
	
	void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	String getEmployeeName() {
		return employeeName;
	}
	
	void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
	
	
}
