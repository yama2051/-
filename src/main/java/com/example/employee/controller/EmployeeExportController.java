package com.example.employee.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.entity.EmployeeEntity;
import com.example.employee.form.EmployeeSearchForm;
import com.example.employee.service.EmployeeService;

/**
 * 職員情報のエクスポート処理を担当するコントローラ
 */
@Controller
public class EmployeeExportController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/exportSearch")
    public String showExportSearch() {
        return "exportSearch";
    }

    @RequestMapping("/exportCsv")
    public ResponseEntity<byte[]> exportCsv(EmployeeSearchForm form) throws IOException {
        if (form == null) {
            form = new EmployeeSearchForm();
        }
        List<EmployeeEntity> all = employeeService.findAllShokuin(form);

        StringBuilder sb = new StringBuilder();
        // BOM
        sb.append('\uFEFF');
        // ヘッダー
        sb.append("社員番号,姓,名,部署,在職区分,メールアドレス,内線番号,入社年月,備考\n");
        for (EmployeeEntity e : all) {
            String mail = e.getDetail() != null ? e.getDetail().getEmail() : "";
            String ext = e.getDetail() != null ? e.getDetail().getExtensionNumber() : "";
            String hire = e.getDetail() != null ? e.getDetail().getHireDate() : "";
            String memo = e.getDetail() != null ? e.getDetail().getMemo() : "";
            String line = String.join(",",
                    e.getEmployeeId() == null ? "" : e.getEmployeeId(),
                    e.getLastName() == null ? "" : e.getLastName(),
                    e.getFirstName() == null ? "" : e.getFirstName(),
                    e.getDepartment() == null ? "" : e.getDepartment(),
                    e.getStatus() == null ? "" : e.getStatus(),
                    mail,
                    ext,
                    hire,
                    memo
            );
            sb.append(line).append('\n');
        }
        byte[] bytes = sb.toString().getBytes(StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/csv; charset=UTF-8"));
        headers.setContentDispositionFormData("attachment", "employees.csv");
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}