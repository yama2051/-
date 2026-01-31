package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.form.EmployeeForm;
import com.example.employee.service.EmployeeService;

/**
 *登録処理 
 */

public class EmployeeRegisterController {
	@Autowired
	private EmployeeService employeeservice;
	
	@RequestMapping("/register")
	public String registMember(EmployeeForm employeeForm,Model model) {
		
		List<EmployeeForm> memberList = new ArrayList<>();
		
		memberList.add(employeeForm);
		
		model.addAttribute(memberList);
		
		return "success";
	}
}
