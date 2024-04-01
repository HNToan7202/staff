package com.example.staff.service;

import com.example.staff.dto.EmployeeDTO;
import com.example.staff.entity.Employee;
import com.example.staff.model.ActionResult;

import java.util.List;

public interface EmployeeService {
    ActionResult addEmployee(EmployeeDTO employeeDTO);

    ActionResult getAllEmployee(Integer page, Integer size);


}
