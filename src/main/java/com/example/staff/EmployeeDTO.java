package com.example.staff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String employeeNumber; // Số nhân viên (3 chữ số)
    private String name; // Tên nhân viên
    private String phone; // Số điện thoại
    private String position; // Chức vụ
    private String email; // Địa chỉ email
}