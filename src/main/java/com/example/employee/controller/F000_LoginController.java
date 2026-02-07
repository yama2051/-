package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String login(EmployeeLoginForm loginForm,Model model) {
		
		/*		System.out.println("入力されたID: " + loginForm.getEmployeeId());
		System.out.println("入力されたPW: " + loginForm.getPassword());*/
		
		EmployeeLoginEntity loginUser = employeeService.findPassOfLogin(loginForm.getEmployeeId());
		
		//職員の存在チェックとパスワードの一致チェック
		if(loginUser == null || !loginUser.getPassword().equals(loginForm.getPassword())) {
			return "login";
		}
		
		return "search";
	}
}
