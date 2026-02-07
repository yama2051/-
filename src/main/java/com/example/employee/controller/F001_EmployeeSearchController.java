package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.entity.EmployeeEntity;
import com.example.employee.form.EmployeeSearchForm;
import com.example.employee.service.EmployeeService;

/**
 * 検索処理用
 */
@Controller
public class F001_EmployeeSearchController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	List<EmployeeEntity> employeeEntityForm;
	
	@RequestMapping("/search")
	public String getResult(EmployeeSearchForm employeeSearchForm,Model model) {
		//デバッグ用
		System.out.println("確認:"+employeeSearchForm.getEmployeeId());
		
		employeeEntityForm = employeeservice.findAllShokuin(employeeSearchForm);
				
		model.addAttribute("employeeForm",employeeEntityForm);
		
		return "list";
	}

}
