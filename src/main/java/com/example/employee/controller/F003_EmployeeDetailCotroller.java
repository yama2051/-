package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employee.form.EmployeeForm;
import com.example.employee.service.EmployeeService;


/**
 *職員詳細画面用 
 */
@Controller
public class F003_EmployeeDetailCotroller {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@RequestMapping("/detail")
	public String detai(@RequestParam("id") String id,Model model) {
		
		EmployeeForm empDetailForm = employeeservice.detailMember(id);
		model.addAttribute("detailForm",empDetailForm);
		
		return "detailPage";
		
	}

}
