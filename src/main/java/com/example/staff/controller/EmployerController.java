package com.example.staff.controller;

import com.example.staff.EmployeeDTO;
import com.example.staff.model.ResponseBuild;
import com.example.staff.model.ResponseModel;
import com.example.staff.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployerController {
    @Autowired private EmployeeService employeeService;

    @Autowired
    ResponseBuild responseBuild;
    @PostMapping("/add")
    public ResponseModel addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return responseBuild.build(employeeService.addEmployee(employeeDTO));
    }

}
