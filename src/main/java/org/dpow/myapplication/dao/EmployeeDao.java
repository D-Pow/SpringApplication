package org.dpow.myapplication.dao;

import org.dpow.myapplication.dao.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployeesByName(String name);
}
