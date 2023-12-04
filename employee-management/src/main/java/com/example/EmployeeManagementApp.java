package com.example;
import java.util.Scanner;
import java.util.List;

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmployeeService employeeService = new EmployeeService(employeeDAO);
        Scanner scanner = new Scanner(System.in);

        // Adding 11 sample employees
        employeeService.addEmployee(new Employee(1, "Rohit Sharma", 60000));
        employeeService.addEmployee(new Employee(2, "Shubham Gill", 55000));
        employeeService.addEmployee(new Employee(3, "Virat Kohli", 62000));
        employeeService.addEmployee(new Employee(4, "KL Rahul", 58000));
        employeeService.addEmployee(new Employee(5, "Shreyash Iyer", 62000));
        employeeService.addEmployee(new Employee(6, "SuryaKumar Yadav", 54000));
        employeeService.addEmployee(new Employee(7, "Ravindra Jadega", 58000));
        employeeService.addEmployee(new Employee(8, "Jasprit Bumrah", 63000));
        employeeService.addEmployee(new Employee(9, "Mohammad Siraj", 57000));
        employeeService.addEmployee(new Employee(10, "Mohammad Shami", 61000));
        employeeService.addEmployee(new Employee(11, "Kuldeep Yadav", 61000));

        boolean exit = false;

        while (!exit) {
            System.out.println("Employee Management Menu:");
            System.out.println("1. List All Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Sort Employees by Salary");
            System.out.println("6. Sort Employees by Name");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // List all employees
                    List<Employee> allEmployees = employeeService.getAllEmployees();
                    if (allEmployees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("All Employees:");
                        for (Employee employee : allEmployees) {
                            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Salary: " + employee.getSalary());
                        }
                    }
                    break;

                case 2:
                    // Adding an employee with ID, name, and salary
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    Employee newEmployee = new Employee(id, name, salary);
                    employeeService.addEmployee(newEmployee);
                    System.out.println("Employee added successfully.");
                    break;

                case 3:
                    // Update an employee
                    System.out.print("Enter the ID of the employee you want to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Employee existingEmployee = employeeService.getEmployeeById(updateId);

                    if (existingEmployee != null) {
                        System.out.print("Enter the updated name: ");
                        String updatedName = scanner.nextLine();
                        System.out.print("Enter the updated salary: ");
                        double updatedSalary = scanner.nextDouble();
                        scanner.nextLine();
                        existingEmployee.setName(updatedName);
                        existingEmployee.setSalary(updatedSalary);
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee with ID " + updateId + " not found.");
                    }
                    break;

                case 4:
                    // Delete an employee
                    System.out.print("Enter the ID of the employee you want to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    // Call the deleteEmployee method
                    employeeService.deleteEmployee(deleteId);
                    System.out.println("Employee with ID " + deleteId + " deleted.");
                    break;

                case 5:
                    List<Employee> employeesBySalary = employeeService.getEmployeesSortedBySalary();
                    System.out.println("\nEmployees sorted by salary:");
                    for (Employee employee : employeesBySalary) {
                        System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Salary: " + employee.getSalary());
                    }
                    break;

                case 6:
                    List<Employee> employeesByName = employeeService.getEmployeesSortedByName();
                    System.out.println("\nEmployees sorted by name:");
                    for (Employee employee : employeesByName) {
                        System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Salary: " + employee.getSalary());
                    }
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting the Employee Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
