package com.management.stock.repository;

import com.management.stock.model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductRepository {
    private String host = "jdbc:mysql://localhost:3306/stockManagement";
    private String dbUsername = "root";
    private String dbPassword = "1234";


    public void insert(String name, String category, String gender, int price, int stock, String codeScan, String image) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "INSERT INTO products ( name,  category,  gender,  price,  stock, codeScan, image) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            System.out.println(image);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, category);
            statement.setString(3, gender);
            statement.setInt(4, price);
            statement.setInt(5, stock);
            statement.setString(6, codeScan);
            statement.setString(7,image);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("A new product has inserted successfully.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateByName(String name, String category, String gender, int price, int stock, String codeScan, String image) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE products SET  category=?, gender=?, price=?,stock=?,codeScan=?, image =? WHERE name =? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, category);
            statement.setString(2, gender);
            statement.setInt(3, price);
            statement.setInt(4, stock);
            statement.setString(5, codeScan);
            statement.setString(6, name);
            statement.setString(7, image);


            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been updated.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateById(int id, String name, String category, String gender, int price, int stock, String codeScan, String image) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE products SET name=?,  category=?, gender=?, price=?,stock=?,codeScan=?,image=? WHERE user_id =? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, category);
            statement.setString(3, gender);
            statement.setInt(4, price);
            statement.setInt(5, stock);
            statement.setString(6, codeScan);
            statement.setString(7, image);
            statement.setInt(8, id);


            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been updated.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateStockById(Long id, int stock) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE products SET stock=? WHERE user_id =? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(2, stock);
            statement.setLong(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been updated.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteByName(String name) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "DELETE FROM products WHERE name =?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been deleted.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteById(int id) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "DELETE FROM products WHERE user_id =?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been deleted.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Product selectById(Long id) {
        Product product = null;
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM products WHERE  user_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();


            if (result.next()) {
                int user_id = result.getInt("user_id");
                String name = result.getString("name");
                String category = result.getString("category");
                String gender = result.getString("gender");
                int price = result.getInt("price");
                int stock = result.getInt("stock");
                String codeScan = result.getString("codeScan");
                String image = result.getString("image");

                product = new Product(user_id, name, category, gender, price, stock, codeScan,image);

            }

            connection.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public Product selectByCategory(String category1) {
        Product product = null;
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM products  WHERE  category=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category1);
            ResultSet result = statement.executeQuery();


            while (result.next()) {
                int user_id = result.getInt("user_id");
                String name = result.getString("name");
                String category = result.getString("category");
                String gender = result.getString("gender");
                int price = result.getInt("price");
                int stock = result.getInt("stock");
                String codeScan = result.getString("codeScan");
                String image = result.getString("image");

                product = new Product(user_id, name, category, gender, price, stock, codeScan,image);

            }

            connection.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public Product selectByCodeScan(String codeScan1) {
        Product product = null;
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM products  WHERE  codeScan=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, codeScan1);
            ResultSet result = statement.executeQuery();


            if (result.next()) {
                int user_id = result.getInt("user_id");
                String name = result.getString("name");
                String category = result.getString("category");
                String gender = result.getString("gender");
                int price = result.getInt("price");
                int stock = result.getInt("stock");
                String codeScan = result.getString("codeScan");
                String image = result.getString("image");

                product = new Product(user_id, name, category, gender, price, stock, codeScan,image);

            }

            connection.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public ArrayList<Product> selectAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);


            while (result.next()) {
                int userId = result.getInt("user_id");
                String name = result.getString("name");
                String category = result.getString("category");
                String gender = result.getString("gender");
                int price = result.getInt("price");
                int stock = result.getInt("stock");
                String codeScan = result.getString("codeScan");
                String image = result.getString("image");

                Product product = new Product(userId,name,category,gender,price,stock,codeScan,image);

                products.add(product);


            }

            connection.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public void updateStockByCodeScan(String codeScan, int stock) {

        try {
            Connection connection = DriverManager.getConnection(host, dbUsername, dbPassword);

            String sql = "UPDATE products SET stock=? WHERE codeScan =? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, stock);
            statement.setString(2, codeScan);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been updated.");
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}