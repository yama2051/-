package com.example.employee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.employee.entity.EmployeeEntity;
import com.example.employee.form.EmployeeSearchForm;


/**
 * やり取り用
 */
@Mapper
public interface EmployeeMapper {
	
	List<EmployeeEntity> findAll(EmployeeSearchForm form);

	void registMem(EmployeeEntity empEntForm);

}
