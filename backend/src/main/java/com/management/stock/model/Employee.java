package com.management.stock.model;

public class Employee {

    private long id;
    private String name;
    private String lastName;
    private String department;

    public Employee(long id, String name, String lastName, String department) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
