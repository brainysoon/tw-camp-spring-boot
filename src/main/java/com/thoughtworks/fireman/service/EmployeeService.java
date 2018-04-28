package com.thoughtworks.fireman.service;

import com.thoughtworks.fireman.domain.Employee;

import java.util.List;

public interface EmployeeService {

    int add(Employee employee);

    Employee deleteById(int id);

    int updateById(Employee employee);

    List<Employee> queryByName(String name);
}
