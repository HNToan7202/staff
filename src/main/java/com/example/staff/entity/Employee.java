package com.example.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String employeeNumber; // Số nhân viên (3 chữ số)
    private String name; // Tên nhân viên
    private String phone; // Số điện thoại
    private String position; // Chức vụ
    private String email; // Địa chỉ email
}
