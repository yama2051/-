package com.example.employee.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.employee.entity.EmployeeDeitalInfEntity;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.form.EmployeeForm;
import com.example.employee.form.EmployeeSearchForm;


/**
 * やり取り用
 */
@Mapper
public interface EmployeeMapper {
	
	List<EmployeeEntity> findAll(EmployeeSearchForm form);

	void registMem(EmployeeEntity empEntForm);
	
	void registDetailMem(EmployeeDeitalInfEntity empEnt);
	
	//詳細画面用
	EmployeeEntity findMemDetail(String employeeId);
	
	//論理削除
	void delete(String employeeId,Timestamp updatedAt);
	
	//更新
	void updateBasic(EmployeeForm empForm,Timestamp updatedAt);
	
	void updateDetail(EmployeeForm empForm,Timestamp updatedAt);
	

}
