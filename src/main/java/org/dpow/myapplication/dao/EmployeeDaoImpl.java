package org.dpow.myapplication.dao;

import org.dpow.myapplication.dao.model.Employee;
import org.dpow.myapplication.dao.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the EmployeeDao interface
 *
 * We pass in the name of the DAO interface that this (implementation) class adheres to. This allows
 * any `@Autowired EmployeeDao employeeDao` tags in other packages to automatically wire this class as the
 * implementation when it imports the `EmployeeDao` interface.
 *
 * This is very similar to the @Component annotation, except it allows for the additional benefit of letting
 * [Spring Data JPA](https://spring.io/projects/spring-data-jpa) to automatically implement the basic operations
 * of any interface extending JpaRepository (in this example, the EmployeeRepository interface).
 * In this way, @Repository marks that this class provides the mechanism for persistence operations
 * (store, retrieve, update, delete, etc.) which @Component would not do alone without a specified bean XML file.
 *
 * Note on access modifiers:
 *   - This is a `default` (not `public`) class because outer packages should import/autowire the EmployeeDao
 *     interface rather than this direct-implementation class.
 *   - The model/ and persistence/ classes have to be `public` in order for the dao/ classes to access them.
 *     Furthermore, the model/ classes will be used in the Rest API/related classes as return objects,
 *     so it must be public. The JpaRepositories could theoretically be `default` just like this implementation
 *     class, but because they are nested in the persistence/ package, they have to be public for this class to
 *     find them.
 */
@Repository("EmployeeDao")
class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.getEmployeesByName(name);
    }
}
