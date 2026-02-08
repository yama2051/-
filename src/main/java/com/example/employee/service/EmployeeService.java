package com.example.employee.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.EmployeeDeitalInfEntity;
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
	
	/**ログイン情報の検索
	 * @param employeeId
	 * @return
	 */
	public EmployeeLoginEntity findPassOfLogin(String employeeId) {
		EmployeeLoginEntity loginEntity = employeeLoginMapper.findPass(employeeId);
		return loginEntity;
	}
	
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	/**全件検索
	 * @param form
	 * @return
	 */
	public List<EmployeeEntity> findAllShokuin(EmployeeSearchForm form) {
		
		return employeeMapper.findAll(form);
	}
	
	/**職員登録用
	 * @param form
	 */
	@SuppressWarnings("null")
	public void registMember(EmployeeForm form) {
		EmployeeEntity empEntForm = new EmployeeEntity();;
		empEntForm.setLastName(form.getLastName());
		empEntForm.setFirstName(form.getFirstName());
		empEntForm.setEmployeeId(form.getEmployeeId());
		empEntForm.setDepartmentId(form.getDepartmentId());
		empEntForm.setStatus(form.getStatus());
		
		empEntForm.setDeleteFlg("0"); // 削除フラグを未削除(0)に
	    
	    // 現在日時をセット
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    empEntForm.setCreatedAt(now); 
	    empEntForm.setUpdatedAt(now);
		
		employeeMapper.registMem(empEntForm);
	}
	
	
	
	/**詳細登録用
	 * @param form
	 */
	public void registDetailMember(EmployeeForm form) {
		EmployeeDeitalInfEntity empEnt = new EmployeeDeitalInfEntity();
		empEnt.setEmployeeId(form.getEmployeeId());
		empEnt.setEmail(form.getEmail());
		empEnt.setExtensionNumber(form.getExtensionNumber());
		empEnt.setHireDate(form.getHireDate());
		empEnt.setMemo(form.getMemo());
		
		System.out.println(form.getEmployeeId());
		
		employeeMapper.registDetailMem(empEnt);
	}

	
	/**職員詳細
	 * 
	 */
	@SuppressWarnings("null")
	public EmployeeForm detailMember(String employeeId) {
		
		EmployeeEntity detailEnt = employeeMapper.findMemDetail(employeeId);
		
		if (detailEnt == null) {
	        return null; 
	    }
		
		EmployeeForm empDetailForm = new EmployeeForm();;
		// 基本情報（employeeテーブル分）
		empDetailForm.setEmployeeId(detailEnt.getEmployeeId());
		empDetailForm.setLastName(detailEnt.getLastName());
		empDetailForm.setFirstName(detailEnt.getFirstName());
		empDetailForm.setDepartmentId(detailEnt.getDepartmentId());
		empDetailForm.setStatus(detailEnt.getStatus());
        
        // 詳細情報（employee_detailsテーブル分）
        // Entityを分けた場合は entity.getDetail().getEmail() のように取得
        if (detailEnt.getDetail() != null) {
        	empDetailForm.setEmail(detailEnt.getDetail().getEmail());
        	empDetailForm.setExtensionNumber(detailEnt.getDetail().getExtensionNumber());
        	empDetailForm.setHireDate(detailEnt.getDetail().getHireDate());
        	empDetailForm.setMemo(detailEnt.getDetail().getMemo());
        }
		
		return empDetailForm;
	}
	
	/**·削除用
	 * @param employeeId
	 */
	public void logicalDelete(String employeeId) {
		
		// 現在日時をセット
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    
	    employeeMapper.delete(employeeId,now);
	}
	
	/**更新基本
	 * @param employeeId
	 */
	public void updateBasic(EmployeeForm empForm) {
		
		// 現在日時をセット
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    
	    employeeMapper.updateBasic(empForm, now);
	}
	
	/**更新詳細
	 * @param employeeId
	 */
	public void updateDetail(EmployeeForm empForm) {
		
		// 現在日時をセット
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    
	    employeeMapper.updateDetail(empForm, now);
	}
	
	
	
}
