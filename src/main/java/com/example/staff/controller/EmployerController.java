package com.example.staff.controller;

import com.example.staff.dto.EmployeeDTO;
import com.example.staff.model.ResponseBuild;
import com.example.staff.model.ResponseModel;
import com.example.staff.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployerController {
    @Autowired private EmployeeService employeeService;

    @Autowired
    ResponseBuild responseBuild;
    @GetMapping
    public ResponseModel getAllEmployee( @RequestParam(defaultValue = "10") Integer size,
                                         @RequestParam(defaultValue = "1") Integer page) {
        return responseBuild.build(employeeService.getAllEmployee(page, size ));
    }
    @PostMapping("/add")
    public ResponseModel addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return responseBuild.build(employeeService.addEmployee(employeeDTO));
    }


}
