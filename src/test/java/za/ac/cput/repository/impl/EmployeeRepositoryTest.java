/*
EmployeeRepositoryTest.java
Author: Musa Banathi Nkosi (221744517)
 */

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    private EmployeeRepository repository;
    private Employee employee1, employee2, employee3;

    @BeforeEach
    void setUp() {
        repository = new EmployeeRepository();

        // Creating test employees
        employee1 = EmployeeFactory.createEmployee(1, "Musa", "Nkosi", "m.n@cput.ac.za", "Cashier", 35000);
        employee2 = EmployeeFactory.createEmployee(2, "Siphosethu", "Msengeni", "s.m@cput.ac.za", "Manager", 50000);
        employee3 = EmployeeFactory.createEmployee(3, "Ashton", "Petersen", "a.p@cput.ac.za", "Sales Assistant", 28000);

        // Adding employees to repository
        repository.save(employee1);
        repository.save(employee2);
        repository.save(employee3);
    }

    @Test
    void testCreate() {
        Employee newEmployee = EmployeeFactory.createEmployee(4, "Thabo", "Molefe", "t.molefe@cput.ac.za", "Supervisor", 40000);
        assertNotNull(repository.save(newEmployee)); // Ensure the employee is saved
    }

    @Test
    void testRead() {
        assertEquals(employee1, repository.read(1)); // Check if the correct employee is returned
    }

    @Test
    void testUpdate() {
        Employee updatedEmployee = new Employee.Builder()
                .setEmployeeID(1)
                .setFirstName("Musa")
                .setLastName("Nkosi")
                .setEmail("m.n@cput.ac.za")
                .setPosition("Senior Cashier") // Updated position
                .setSalary(37000) // Updated salary
                .build();

        repository.update(updatedEmployee);
        assertEquals("Senior Cashier", repository.read(1).getPosition()); // Validate update
    }

    @Test
    void testDelete() {
        assertTrue(repository.delete(3)); // Ensure employee is deleted
        assertNull(repository.read(3)); // Check if employee is removed
    }

    @Test
    void testFindAll() {
        List<Employee> employees = repository.getAll(); // Using getAll() instead of findAll()
        assertEquals(3, employees.size()); // Ensure all employees are returned
    }

    @Test
    void testFindByLastName() {
        List<Employee> result = repository.findByLastName("Msengeni");
        assertEquals(1, result.size()); // Ensure correct employee count
    }

    @Test
    void testFindByPosition() {
        List<Employee> result = repository.findByPosition("Manager");
        assertEquals(1, result.size()); // Ensure correct position search
    }

    @Test
    void testFindBySalaryRange() {
        List<Employee> result = repository.findBySalaryRange(30000, 50000);
        assertEquals(2, result.size()); // Ensure two employees fall within the range
    }
}
