package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employee.entity.EmployeeLoginEntity;
import com.example.employee.form.EmployeeLoginForm;
import com.example.employee.service.EmployeeService;



/**
 * ログイン時に使用される
 */
@Controller
public class F000_LoginController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/init")
	public String init() {
		
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(EmployeeLoginForm loginForm,@RequestParam String employeeId, @RequestParam String password,Model model) {

		EmployeeLoginEntity loginUser = employeeService.findPassOfLogin(loginForm.getEmployeeId());
		
		String errorMsg = employeeService.chekuError(employeeId, password);
		
		//職員の存在チェックとパスワードの一致チェック
		if(errorMsg != null) {
			model.addAttribute("errorMessage", errorMsg);
			return "login";
		}
		
		return "search";
	}
}
