/*
IEmployeeRepository.java
Author: Musa Banathi Nkosi (221744517)
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee, Integer> {

    // Saves an Employee entity to the repository
    Employee save(Employee employee);

    // Finds employees by their last name
    List<Employee> findByLastName(String lastName);

    // Finds employees by their job position
    List<Employee> findByPosition(String position);

    // Finds employees within a specified salary range
    List<Employee> findBySalaryRange(double minSalary, double maxSalary);
}
