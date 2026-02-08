package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.form.EmployeeForm;
import com.example.employee.service.EmployeeService;

/**
 * 更新処理用
 */
@Controller
public class F004_EmployeeUpdateController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	
	/**編集画面へ遷移する。
	 * @param emplooyeeId
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	
	public String edit(String employeeId,Model model) {
		
		EmployeeForm editForm = employeeservice.detailMember(employeeId);
		model.addAttribute(editForm);
		
		return "editFinish";
	}
	
	@RequestMapping("/update")
	public String update(EmployeeForm empForm) {
		
		employeeservice.updateBasic(empForm);
		employeeservice.updateDetail(empForm);
		
		return "redirect:/search";
	}
	

	
}
