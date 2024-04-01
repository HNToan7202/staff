package com.example.staff.service.Impl;

import com.example.staff.EmployeeDTO;
import com.example.staff.model.ActionResult;
import com.example.staff.repository.EmployeeRepository;
import com.example.staff.service.EmployeeService;
import com.example.staff.util.Constants;
import com.example.staff.util.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    SimpleDateFormat dateFomat = new SimpleDateFormat(Constants.DATE_FORMAT);

    public ActionResult addEmployee(EmployeeDTO employeeDTO) {
        ActionResult result = new ActionResult();
        try {



        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
            System.out.println(e.getMessage());
        }
        return result;
    }

}
