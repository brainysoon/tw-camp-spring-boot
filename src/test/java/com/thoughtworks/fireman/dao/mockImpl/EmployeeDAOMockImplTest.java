package com.thoughtworks.fireman.dao.mockImpl;

import com.thoughtworks.fireman.Application;
import com.thoughtworks.fireman.db.MockDB;
import com.thoughtworks.fireman.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class EmployeeDAOMockImplTest {

    @Mock
    private MockDB mockDB;

    @InjectMocks
    private EmployeeDAOMockImpl employeeDAOMockImpl;

    @Test
    public void add_should_return_negative_one_when_there_already_have_one() {
        Employee employee = new Employee();
        given(mockDB.contains(employee)).willReturn(true);

        int addResult = employeeDAOMockImpl.add(employee);

        assertEquals(-1, addResult);
    }

    @Test
    public void add_should_return_the_id_when_add_successfully() {
        Employee employee = new Employee();
        given(mockDB.contains(employee)).willReturn(false);

        int addResult = employeeDAOMockImpl.add(employee);

        assertEquals(0, addResult);
    }

    @Test
    public void deleteById_should_return_the_deleted_employee() {
        Employee employee = new Employee();
        given(mockDB.remove(0)).willReturn(employee);

        Employee deletedEmployee = employeeDAOMockImpl.deleteById(0);

        assertEquals(employee, deletedEmployee);
    }

    @Test
    public void updateById_should_return_updated_id_when_update_successfully() {
        Employee employee = new Employee();
        given(mockDB.set(employee.getId(), employee)).willReturn(employee);

        int updatedId = employeeDAOMockImpl.updateById(employee);

        assertEquals(0, updatedId);
    }

    @Test
    public void queryByName_should_return_the_list_that_match_the_name() {
        ArrayList<Employee> realList = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setName("employee1");
        employee2.setName("employee2");
        realList.add(employee1);
        realList.add(employee2);
        given(mockDB.stream()).willReturn(realList.stream());

        List<Employee> employees = employeeDAOMockImpl.queryByName("employee");

        assertEquals(2, employees.size());
    }
}
