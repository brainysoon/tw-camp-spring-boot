package com.thoughtworks.fireman.controller;

import com.thoughtworks.fireman.constant.UriConstants;
import com.thoughtworks.fireman.constant.ViewNameConstants;
import com.thoughtworks.fireman.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(UriConstants.VIEW_EMPLOYEE)
public class EmployeeViewController {

    private static final String EMPLOYEES = "employees";
    
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(UriConstants.ALL)
    public ModelAndView tableViewAll(ModelAndView modelAndView) {

        modelAndView.addObject(EMPLOYEES, employeeService.queryByName(""));
        modelAndView.setViewName(ViewNameConstants.EMPLOYEE_TABLE);

        return modelAndView;
    }
}
