package com.thoughtworks.fireman.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() throws Exception {

        employee = new Employee();
        employee.setId(1);
    }

    @Test
    public void equals_should_return_true_when_the_id_of_the_two_is_same() {
        Employee testEmployee = new Employee();
        testEmployee.setId(1);

        boolean isEquals = employee.equals(testEmployee);

        assertTrue(isEquals);
    }

    @Test
    public void equals_should_return_false_when_the_id_of_the_two_is_not_same() {
        Employee testEmployee = new Employee();
        testEmployee.setId(2);

        boolean isEquals = employee.equals(testEmployee);

        assertFalse(isEquals);
    }
}
