package com.management.stock.repository;

import com.management.stock.config.DbConfig;
import com.management.stock.model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository {

    Connection dbConnection;

    public EmployeeRepository() {
        try {
            this.dbConnection = DriverManager.getConnection(DbConfig.host, DbConfig.dbUsername, DbConfig.dbPassword);
        } catch(Exception e) {
            System.out.println("error message here");
            System.out.println(e.getMessage());
            throw new RuntimeException("Database not available");
        }
    }

    public ArrayList<Employee> findAllEmployers() {
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM employers ";
            Statement statement = dbConnection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);

            while (result.next()) {
                int userId = result.getInt("id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String department = result.getString("department");
                Employee employee = new Employee(userId,name,lastName,department);
                employees.add(employee);
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
            String sql = "SELECT * FROM employers  WHERE user_id = ? ";

            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                Long userId = result.getLong("id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String department = result.getString("department");

                employee = new Employee(userId,name,lastName,department);
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    public void createEmployee(Employee newEmployee) {
        try {
            String sqlQuery = "INSERT INTO employers ( name,  lastName,  department ) "
                    + "VALUES (?, ?, ? )";

            PreparedStatement statement = dbConnection.prepareStatement(sqlQuery);
            statement.setString(1, newEmployee.getName());
            statement.setString(2, newEmployee.getLastName());
            statement.setString(3, newEmployee.getDepartment());

            int result = statement.executeUpdate();

            if (result > 0) {
                System.out.println("A new employee has been inserted successfully.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateEmployeeById(int id, Employee employee) {
        try {
            String sqlQuery = "UPDATE employers SET name=?, lastName=?,department=? WHERE user_id =? ";

            PreparedStatement statement = dbConnection.prepareStatement(sqlQuery);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getDepartment());
            statement.setInt(4, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the employe information has been updated.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteEmployeeById(int id) {
        try {
            String sqlQuery = "DELETE FROM employers WHERE user_id = ?";

            PreparedStatement statement = dbConnection.prepareStatement(sqlQuery);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the use's information has been deleted.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
