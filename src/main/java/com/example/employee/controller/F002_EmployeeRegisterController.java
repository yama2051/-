package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.form.EmployeeForm;
import com.example.employee.service.EmployeeService;

/**
 *登録処理 
 */

@Controller
public class F002_EmployeeRegisterController {
	@Autowired
	private EmployeeService employeeservice;
	
	/**登録画面へ
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping("/register")
	
	public String registMember() {
		
		return "registPage";
	}
	
	/**登録完了
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping("/registFinish")
	
	public String registFin(EmployeeForm employeeForm,Model model) {
		
		List<EmployeeForm> memberList = new ArrayList<>();
		
		employeeservice.registMember(employeeForm);
		employeeservice.registDetailMember(employeeForm);
		
		memberList.add(employeeForm);
		
		model.addAttribute(memberList);
		
		return"success";
	}
}
