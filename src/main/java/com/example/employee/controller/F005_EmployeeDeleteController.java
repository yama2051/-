package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.service.EmployeeService;

/**
 * 削除用Controller
 */
@Controller

public class F005_EmployeeDeleteController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/delete")
	public String delete(String employeeId) {
		
		employeeService.logicalDelete(employeeId);
		
		return "redirect:/search";
	}

}
