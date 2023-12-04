package com.example;

public class Employee {

	private int id;
    private String name;
    private double salary;
	public Employee(int id2,String name2, double salary2) {
		this.id=id2;
		this.name = name2;
        this.salary = salary2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
    
}

