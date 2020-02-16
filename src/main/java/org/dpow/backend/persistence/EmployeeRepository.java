package org.dpow.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(
            "SELECT employee " +
            "FROM Employee employee " +
            "WHERE LOWER(employee.name) LIKE %:name%"
    )
    List<Employee> getEmployeesByName(@Param("name") String name);
}
