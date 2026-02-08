package com.example.employee.form;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 検索条件保持
 */
@Data
public class EmployeeSearchForm {
	
	private String employeeId;
	private String lastName;
	private String firstName;
	private String departmentId;
	private String status;
	private String deleteFlg;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
