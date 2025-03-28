/*
EmployeeRepository.java
Author: Musa Banathi Nkosi (221744517)
 */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final List<Employee> employeeList;

    // Constructor to initialize the list
    public EmployeeRepository() {
        this.employeeList = new ArrayList<>();
    }

    // Saves an Employee to the repository
    @Override
    public Employee save(Employee employee) {
        if (employee == null) return null;
        employeeList.add(employee);
        return employee;
    }

    // Creates an Employee (not yet implemented)
    @Override
    public Employee create(Employee employee) {
        return null;
    }

    // Reads an Employee by ID
    @Override
    public Employee read(Integer employeeID) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID() == employeeID) {
                return emp;
            }
        }
        return null;
    }

    // Updates an Employee (not yet implemented)
    @Override
    public Employee update(Employee employee) {
        return null;
    }

    // Deletes an Employee by ID
    @Override
    public boolean delete(Integer employeeID) {
        Employee employee = read(employeeID);
        if (employee != null) {
            employeeList.remove(employee);
            return true;
        }
        return false;
    }

    // Returns an empty list (should be modified to return all employees)
    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    // Finds employees by last name
    @Override
    public List<Employee> findByLastName(String lastName) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getLastName().equalsIgnoreCase(lastName)) {
                result.add(emp);
            }
        }
        return result;
    }

    // Finds employees by position
    @Override
    public List<Employee> findByPosition(String position) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getPosition().equalsIgnoreCase(position)) {
                result.add(emp);
            }
        }
        return result;
    }

    // Finds employees within a salary range
    @Override
    public List<Employee> findBySalaryRange(double minSalary, double maxSalary) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getSalary() >= minSalary && emp.getSalary() <= maxSalary) {
                result.add(emp);
            }
        }
        return result;
    }

    // Returns a copy of all employees in the list
    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }
}
