package com.thoughtworks.fireman.db;

import com.thoughtworks.fireman.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MockDB extends ArrayList<Employee> {
}
