package com.example.staff.service.Impl;

import com.example.staff.dto.EmployeeDTO;
import com.example.staff.entity.Employee;
import com.example.staff.exception.InvalidEmail;
import com.example.staff.exception.InvalidID;
import com.example.staff.exception.InvalidName;
import com.example.staff.exception.InvalidPhone;
import com.example.staff.model.ActionResult;
import com.example.staff.model.PageModel;
import com.example.staff.repository.EmployeeRepository;
import com.example.staff.service.EmployeeService;
import com.example.staff.util.ErrorCodeEnum;
import com.example.staff.util.Info;
import com.example.staff.util.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ActionResult addEmployee(EmployeeDTO employeeDTO) {
        ActionResult result = new ActionResult();
        try {

            String id = String.valueOf(employeeDTO.getEmployeeNumber());
            if (!Validator.isID(id)) {
                throw new InvalidID(Info.INVALID_ID);
            }
            if (!Validator.isEmail(employeeDTO.getEmail())) {
                throw new InvalidEmail(Info.INVALID_EMAIL);
            }
            if (!Validator.isName(employeeDTO.getName())) {
                throw new InvalidName(Info.INVALID_NAME);
            }
            if (!Validator.isPhoneNumber(employeeDTO.getPhone())) {
                throw new InvalidPhone(Info.INVALID_PHONE);
            }
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            employeeRepository.save(employee);
            result.setErrorCode(ErrorCodeEnum.OK);

        } catch (InvalidID e) {
            result.setErrorCode(ErrorCodeEnum.INVALID_ID);
        } catch (InvalidName e) {
            result.setErrorCode(ErrorCodeEnum.INVALID_NAME);
        } catch (InvalidPhone e) {
            result.setErrorCode(ErrorCodeEnum.INVALID_PHONE);
        } catch (InvalidEmail e) {
            result.setErrorCode(ErrorCodeEnum.INVALID_EMAIL);
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
            System.out.println(e.getMessage());
        }
        return result;
    }


    @Override
    public ActionResult getAllEmployee(Integer page, Integer size) {
        ActionResult result = new ActionResult();
        try {
            Page<Employee> employees = employeeRepository.findAll(PageRequest.of(page - 1, size));
            List<EmployeeDTO> list = employees.getContent().stream().map(EmployeeDTO::transform).collect(Collectors.toList());
            result.setErrorCode(ErrorCodeEnum.OK);
            result.setData(PageModel.transform(employees, list));
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
            System.out.println(e.getMessage());
        }
        return result;
    }


}
