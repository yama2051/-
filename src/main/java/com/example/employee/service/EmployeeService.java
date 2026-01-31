package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.EmployeeEntity;
import com.example.employee.entity.EmployeeLoginEntity;
import com.example.employee.form.EmployeeForm;
import com.example.employee.form.EmployeeSearchForm;
import com.example.employee.mapper.EmployeeLoginMapper;
import com.example.employee.mapper.EmployeeMapper;

/**
 * 業務ロジック用
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeLoginMapper employeeLoginMapper;
	
	//ログイン情報の検索
	public EmployeeLoginEntity findPassOfLogin(String employeeId) {
		EmployeeLoginEntity loginEntity = employeeLoginMapper.findPass(employeeId);
		return loginEntity;
	}
	
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	//全件検索
	public List<EmployeeEntity> findAllShokuin(EmployeeSearchForm form) {
		
		return employeeMapper.findAll(form);
	}
	
	//職員登録
	public void registMember(EmployeeForm form) {
		EmployeeEntity empEntForm = null;
		empEntForm.setLastName(form.getLastName());
		empEntForm.setFirstName(form.getFirstName());
		empEntForm.setEmployeeId(form.getEmployeeId());
		empEntForm.setDepartmentId(form.getDepartmentId());
		empEntForm.setDeleteFlg(form.getDeleteFlg());
		empEntForm.setStatus(form.getStatus());
		empEntForm.setUpdatedAt(form.getUpdatedAt());
		
		employeeMapper.registMem(empEntForm);
	}
	
	//職員詳細画面の表示
	
	
	
}
