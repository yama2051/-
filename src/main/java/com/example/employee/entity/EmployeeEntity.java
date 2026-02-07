package com.example.employee.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmployeeEntity {
	
	private String employeeId;
	private String lastName;
	private String firstName;
	private String departmentId;
	private char status;
	private char deleteFlg;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public void setName(String string) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	//詳細情報
	private EmployeeDeitalInfEntity detail;
	
}
