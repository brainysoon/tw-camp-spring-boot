package com.thoughtworks.fireman.dao;

import com.thoughtworks.fireman.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    int add(Employee employee);

    Employee deleteById(int id);

    int updateById(Employee employee);

    List<Employee> queryByName(String name);
}
