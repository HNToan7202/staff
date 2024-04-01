package com.example.staff.service;

import com.example.staff.dto.EmployeeDTO;
import com.example.staff.entity.Employee;
import com.example.staff.model.ActionResult;

import java.util.List;

public interface EmployeeService {
    ActionResult addEmployee(EmployeeDTO employeeDTO);

    ActionResult getAllEmployee(Integer page, Integer size);


    ActionResult searchEmployee(Integer page, Integer size, Integer employeeNumber, String name, String phone, String position, String email);

    ActionResult updateEmployee(EmployeeDTO employeeDTO, Integer getEmployeeNumber);

    ActionResult deleteEmployee(Integer getEmployeeNumber);
}
