package com.example.staff.service;

import com.example.staff.dto.EmployeeDTO;
import com.example.staff.model.ActionResult;

public interface EmployeeService {
    ActionResult addEmployee(EmployeeDTO employeeDTO);

    ActionResult getAllEmployee(Integer page, Integer size);
}
