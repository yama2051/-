package com.example.employee.entity;

import lombok.Data;

@Data
public class EmployeeLoginEntity {
	
	private String employeeId;
	private String password;
	private String role;

}
