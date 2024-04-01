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
    private String employeeNumber; // Số nhân viên (3 chữ số)
    private String name; // Tên nhân viên
    private String phone; // Số điện thoại
    private String position; // Chức vụ
    private String email; // Địa chỉ email

    public static EmployeeDTO transform(Employee employee) {
        return EmployeeDTO.builder()
                .employeeNumber(String.format("%03d", Integer.parseInt(employee.getEmployeeNumber())))
                .name(employee.getName())
                .phone(employee.getPhone())
                .position(employee.getPosition())
                .email(employee.getEmail())
                .build();
    }
}