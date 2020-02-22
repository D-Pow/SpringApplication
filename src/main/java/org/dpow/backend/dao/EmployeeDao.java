package org.dpow.backend.dao;

import org.dpow.backend.dao.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployeesByName(String name);
}
