/*
EmployeeFactory.java
Author: Musa Banathi Nkosi (221744517)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Employee;

public class EmployeeFactory {

    public static Employee createEmployee(int employeeID, String firstName, String lastName, String email, String position, double salary) {
        // Trim input values to avoid leading/trailing spaces being considered as valid inputs
        firstName = firstName != null ? firstName.trim() : "";
        lastName = lastName != null ? lastName.trim() : "";
        email = email != null ? email.trim() : "";
        position = position != null ? position.trim() : "";

        // Validate required fields
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || position.isEmpty()) {
            throw new IllegalArgumentException("Error: First name, Last name, Email, or Position cannot be empty.");
        }

        // Basic email validation (for stronger validation, use regex)
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Error: Invalid email format.");
        }

        // Validate ID and salary
        if (employeeID <= 0) {
            throw new IllegalArgumentException("Error: Employee ID must be greater than 0.");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Error: Salary must be greater than 0.");
        }

        // Build and return the Employee object
        return new Employee.Builder()
                .setEmployeeID(employeeID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPosition(position)
                .setSalary(salary)
                .build();
    }
}
