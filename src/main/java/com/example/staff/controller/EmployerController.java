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
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    ResponseBuild responseBuild;

    @GetMapping
    public ResponseModel getAllEmployee(@RequestParam(defaultValue = "10") Integer size,
                                        @RequestParam(defaultValue = "1") Integer page) {
        return responseBuild.build(employeeService.getAllEmployee(page, size));
    }

    //searchEmployee
    @GetMapping("/search")
    public ResponseModel searchEmployee(@RequestParam String key,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "1") Integer employeeNumber,
                                        @RequestParam(defaultValue = "") String name,
                                        @RequestParam(defaultValue = "") String phone,
                                        @RequestParam(defaultValue = "") String position,
                                        @RequestParam(defaultValue = "") String email) {
        return responseBuild.build(employeeService.searchEmployee(page, size, employeeNumber, name, phone, position, email));
    }
    @PostMapping
    public ResponseModel addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return responseBuild.build(employeeService.addEmployee(employeeDTO));
    }

    @PutMapping("/{employeeNumber}")
    public ResponseModel updateEmployee(@PathVariable("employeeNumber") Integer employeeNumber, @RequestBody EmployeeDTO employeeDTO) {
        return responseBuild.build(employeeService.updateEmployee(employeeDTO, employeeNumber));
    }

    @DeleteMapping("/{employeeNumber}")
    public ResponseModel deleteEmployee(@PathVariable("employeeNumber") Integer employeeNumber) {
        return responseBuild.build(employeeService.deleteEmployee(employeeNumber));
    }


}
