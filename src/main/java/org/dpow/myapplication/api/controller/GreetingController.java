package org.dpow.myapplication.api.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.dpow.myapplication.api.model.Greeting;
import org.dpow.myapplication.dao.model.Employee;
import org.dpow.myapplication.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingController {
    @Autowired
    private EmployeeDao employeeDao;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public Greeting greeting(String name) {
        List<Employee> employeesWithName = employeeDao.getEmployeesByName(name.toLowerCase());

        if (employeesWithName.size() == 0) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }

        Employee firstEmployee = employeesWithName.get(0);

        return new Greeting(firstEmployee.getId(), firstEmployee.getName(), firstEmployee.getRole());
    }

    public Greeting greeting(String name, String postBody) {
        return new Greeting(counter.incrementAndGet(), name, "You posted: " + postBody);
    }
}
