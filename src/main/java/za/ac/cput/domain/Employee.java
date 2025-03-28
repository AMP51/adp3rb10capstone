/*
Employee.java
Author: Musa Banathi Nkosi (221744517)
 */

package za.ac.cput.domain;

public class Employee {
    // Private attributes
    private int employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private double salary;

    // Private constructor that initializes an Employee object using the Builder
    private Employee(Builder builder) {
        this.employeeID = builder.employeeID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.position = builder.position;
        this.salary = builder.salary;
    }

    // Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    // Returns a string representation of the Employee object
    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Promotes the employee to a new position with a salary increase
    public void promote(String newPosition, double salaryIncrease) {
        System.out.println(firstName + " " + lastName + " has been promoted to " + newPosition);
        this.position = newPosition;
        this.salary += salaryIncrease;
    }

    public boolean isValidEmail() {
        return email != null && email.contains("@");
    }

    // Builder Class
    public static class Builder {
        private int employeeID;
        private String firstName;
        private String lastName;
        private String email;
        private String position;
        private double salary;

        // Sets the employee ID
        public Builder setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        // Sets the first name
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        // Sets the last name
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        // Sets the email address
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        // Sets the job position
        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        // Sets the salary
        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        // Builds and returns an Employee object
        public Employee build() {
            return new Employee(this);
        }
    }
}
