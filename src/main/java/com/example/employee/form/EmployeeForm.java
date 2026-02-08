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
	private String status;
	private String deleteFlg;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	// --- 詳細情報（employee_detailsテーブル） ---
    private String email;           // メールアドレス
    private String extensionNumber; // 内線番号
    private String hireDate;        // 入社年月日
    private String memo;            // 備考
}
