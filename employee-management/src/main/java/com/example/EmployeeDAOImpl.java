package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Add an employee with ID, name, and salary
    @Override
    public void addEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
    }

    // Update an employee by ID, name, and salary
    @Override
    public void updateEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e.getId() == employee.getId()) {
                e.setName(employee.getName());
                e.setSalary(employee.getSalary());
                break;
            }
        }
    }

    // Delete an employee by ID
    @Override
    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }

    // Sort employees by salary
    @Override
    public List<Employee> getEmployeesSortedBySalary() {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, Comparator.comparing(Employee::getSalary));
        return sortedEmployees;
    }

    // Sort employees by name
    @Override
    public List<Employee> getEmployeesSortedByName() {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, Comparator.comparing(Employee::getName));
        return sortedEmployees;
    }

    // Get employee by ID and display details
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
