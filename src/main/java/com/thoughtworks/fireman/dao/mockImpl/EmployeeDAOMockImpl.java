package com.thoughtworks.fireman.dao.mockImpl;

import com.thoughtworks.fireman.dao.EmployeeDAO;
import com.thoughtworks.fireman.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDAOMockImpl implements EmployeeDAO {

    @Autowired
    private List<Employee> mockEmployeeList;

    @Override
    public int add(Employee employee) {

        if (mockEmployeeList.contains(employee)) return -1;

        employee.setId(mockEmployeeList.size());
        mockEmployeeList.add(employee);
        return employee.getId();
    }

    @Override
    public Employee deleteById(int id) {
        return mockEmployeeList.remove(id);
    }

    @Override
    public int updateById(Employee employee) {
        mockEmployeeList.set(employee.getId(), employee);
        return employee.getId();
    }

    @Override
    public List<Employee> queryByName(String name) {
        return mockEmployeeList.stream()
                .filter(employee -> isMatchEmployeeName(name, employee))
                .collect(Collectors.toList());
    }

    private boolean isMatchEmployeeName(String name, Employee employee) {
        String originalName = employee.getName();
        if (originalName == null) return false;

        return originalName.contains(name);
    }
}
