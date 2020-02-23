package org.dpow.myapplication.api;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.dpow.myapplication.dao.model.Employee;
import org.dpow.myapplication.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    private EmployeeDao employeeDao;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<Employee> employeesWithName = employeeDao.getEmployeesByName(name.toLowerCase());

        if (employeesWithName.size() == 0) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }

        Employee firstEmployee = employeesWithName.get(0);

        return new Greeting(firstEmployee.getId(), firstEmployee.getName(), firstEmployee.getRole());
    }

    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, @RequestBody String postBody) {
        return new Greeting(counter.incrementAndGet(), name, "You posted: " + postBody);
    }
}
