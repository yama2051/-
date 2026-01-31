package com.example.employee.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.employee.entity.EmployeeLoginEntity;

@Mapper
public interface EmployeeLoginMapper {
	
	EmployeeLoginEntity findPass(String employeeId);
	
}
