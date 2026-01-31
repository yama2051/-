package com.example.employee.form;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 登録・更新用
 */

@Data
public class EmployeeForm {
	private String employeeId;
	private String lastName;
	private String firstName;
	private String departmentId;
	private char status;
	private char deleteFlg;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
