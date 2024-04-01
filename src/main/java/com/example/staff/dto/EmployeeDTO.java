package com.example.staff.dto;

import com.example.staff.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Integer employeeNumber; // Số nhân viên (3 chữ số)
    private String name; // Tên nhân viên
    private String phone; // Số điện thoại
    private String position; // Chức vụ
    private String email; // Địa chỉ email

    public static EmployeeDTO transform(Employee employee) {
        String formattedEmployeeNumber = String.format("%03d", employee.getEmployeeNumber()); // Định dạng mã số nhân viên thành 3 chữ số
        return EmployeeDTO.builder()
                .employeeNumber(Integer.parseInt(formattedEmployeeNumber)) // Chuyển đổi lại thành kiểu Integer
                .name(employee.getName())
                .phone(employee.getPhone())
                .position(employee.getPosition())
                .email(employee.getEmail())
                .build();
    }
}