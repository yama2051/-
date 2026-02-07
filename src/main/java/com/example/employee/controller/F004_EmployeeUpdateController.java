package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.employee.service.EmployeeService;

/**
 * 更新処理用
 */
@Controller
public class F004_EmployeeUpdateController {
	
	@Autowired
	private EmployeeService employeeservice;
	

	
}
