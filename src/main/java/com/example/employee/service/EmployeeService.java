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
	
	public String chekuError(String employeeId,String password) {
		EmployeeLoginEntity loginEntity = employeeLoginMapper.findPass(employeeId);
		
		if(loginEntity == null) {
			return "社員が存在していません。再度確認をお願いします。";
		}
		
		if(!loginEntity.getPassword().equals(password)) {
			return "パスワードが違います。再度入力をお願いします。";
		}
		
		return null;
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
		
		empEntForm.setDepartment(convertId(form.getDepartmentId()));
		
		empEntForm.setDeleteFlg("0"); // 削除フラグを未削除(0)に
	    
	    // 重複チェック: 既に同一の社員IDが存在する場合は例外を投げる
	    if (empEntForm.getEmployeeId() != null && !empEntForm.getEmployeeId().isEmpty()) {
	        EmployeeEntity exists = employeeMapper.findMemDetail(empEntForm.getEmployeeId());
	        if (exists != null) {
	            throw new IllegalStateException("社員番号は既に存在します。別の社員番号を指定してください。");
	        }
	    }
	    
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
		// サニタイズ・バリデーション
		if (form == null) {
			throw new IllegalStateException("登録情報が不正です。もう一度お試しください。");
		}
		String employeeId = form.getEmployeeId() == null ? "" : form.getEmployeeId().trim();
		String email = form.getEmail() == null ? "" : form.getEmail().trim();
		String extension = form.getExtensionNumber() == null ? "" : form.getExtensionNumber().trim();
		String memo = form.getMemo() == null ? "" : form.getMemo().trim();
		
		// DB カラム長を想定した上限チェック（安全側の値を設定）
		int EMP_ID_MAX = 10;       // employee.employee_id が character varying(10) のため
		int EMAIL_MAX = 254;       // RFC 的な上限を想定
		int EXT_MAX = 50;          // 内線や電話番号を想定
		int MEMO_MAX = 2000;       // 備考は長めに許容
		
		if (employeeId.length() > EMP_ID_MAX) {
			throw new IllegalStateException("社員番号は" + EMP_ID_MAX + "文字以内で入力してください。");
		}
		if (email.length() > EMAIL_MAX) {
			throw new IllegalStateException("メールアドレスが長すぎます（上限 " + EMAIL_MAX + " 文字）。");
		}
		if (extension.length() > EXT_MAX) {
			throw new IllegalStateException("内線番号が長すぎます（上限 " + EXT_MAX + " 文字）。");
		}
		if (memo.length() > MEMO_MAX) {
			throw new IllegalStateException("備考が長すぎます（上限 " + MEMO_MAX + " 文字）。");
		}
		
		EmployeeDeitalInfEntity empEnt = new EmployeeDeitalInfEntity();
		empEnt.setEmployeeId(employeeId);
		empEnt.setEmail(email);
		empEnt.setExtensionNumber(extension);
		empEnt.setHireDate(form.getHireDate());
		empEnt.setMemo(memo);
		
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
		empDetailForm.setDepartment(detailEnt.getDepartment());
        
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
		
		//部署変換
		empForm.setDepartment(convertId(empForm.getDepartmentId()));
		
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
	
	
	/**部署IDを変換する処理
	 * @param departId
	 * @return
	 */
	private String convertId(String departId) {
		
		if(departId == null) {
			return null;
		}
		
		switch (departId) {
        	case "D01": return "開発部";
        	case "D02": return "営業部";
        	case "D03": return "人事部";
        	case "D04": return "総務部";
        	case "D05": return "経理部";
        	case "D11": return "企画部";
        
        	default: return null;
		}
	}


	
	
	
}