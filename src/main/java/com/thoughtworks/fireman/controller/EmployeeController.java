package com.thoughtworks.fireman.controller;

import com.thoughtworks.fireman.constant.UriConstants;
import com.thoughtworks.fireman.domain.Employee;
import com.thoughtworks.fireman.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UriConstants.EMPLOYEE)
public class EmployeeController {

    private static final String EMPTY_NAME = "";

    @Autowired
    private EmployeeService employeeService;

    @DeleteMapping(UriConstants.DELETE_EMPLOYEE)
    public Employee deleteEmployeeById(@RequestParam Integer id) {

        return employeeService.deleteById(id);
    }

    @PostMapping(UriConstants.ADD_EMPLOYEE)
    public Integer add(Employee employee) {

        return employeeService.add(employee);
    }

    @PostMapping(UriConstants.UPDATE_EMPLOYEE)
    public Integer updateById(@RequestParam Employee employee) {

        return employeeService.updateById(employee);
    }

    @GetMapping(UriConstants.QUERY_EMPLOYEE)
    public List<Employee> queryByName(@RequestParam String name) {

        return employeeService.queryByName(name);
    }

    @GetMapping(UriConstants.ALL)
    public List<Employee> all() {

        return employeeService.queryByName(EMPTY_NAME);
    }
}
