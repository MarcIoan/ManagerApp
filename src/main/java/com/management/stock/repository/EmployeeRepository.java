package com.management.stock.repository;

import com.management.stock.model.Employe;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository {

    private String host = "jdbc:mysql://localhost:3306/stockmanagement";
    private String dbUsername = "root";
    private String dbPassword = "1234";



    public void insert(String name, String lastName, String department) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "INSERT INTO employers ( name,  lastName,  department ) "
                    + "VALUES (?, ?, ? )";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, department);


            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("A new employe has inserted successfully.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateByName(String name, String lastName, String department) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE employers SET lastName=?,department=? WHERE name=? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(3, name);
            statement.setString(2, lastName);
            statement.setString(1, department);


            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the employe information has been updated.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void updateById(int id, String name, String lastName, String department) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE employers SET name=?, lastName=?,department=? WHERE user_id =? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, department);
            statement.setInt(4, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the employe information has been updated.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateByIdDepartment(int id, String department1) {
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE employers SET department=? WHERE user_id =? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,department1);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the employe information has been updated.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteByName(String name) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "DELETE FROM employers WHERE name =?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the use's information has been deleted.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteById(int id) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "DELETE FROM employers WHERE user_id =?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the use's information has been deleted.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Employe selectById(Long id) {
        Employe employe = null;
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM employers  WHERE user_id = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();


            if(result.next()) {
                Long userId = result.getLong("user_id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String department = result.getString("department");

                employe = new Employe(userId,name,lastName,department);

            }

            connection.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employe;
    }

    public Employe selectByName(String name1) {
        Employe employe = null;
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM employers  WHERE name = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,name1);
            ResultSet result = statement.executeQuery();


            if(result.next()) {
                int userId = result.getInt("user_id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String department = result.getString("department");

                employe = new Employe(userId,name,lastName,department);

            }

            connection.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employe;
    }

    public ArrayList<Employe> selectAll() {
        ArrayList<Employe> employes = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM employers ";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int userId = result.getInt("user_id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String department = result.getString("department");
                Employe employe  = new Employe(userId,name,lastName,department);
                employes.add(employe);
            }
            connection.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employes;
    }

}
