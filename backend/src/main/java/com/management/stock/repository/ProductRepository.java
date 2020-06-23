package com.management.stock.repository;

import com.management.stock.config.DbConfig;
import com.management.stock.model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductRepository {

    private Connection dbConnection;

    public ProductRepository() {
        try {
            this.dbConnection = DriverManager.getConnection(DbConfig.host, DbConfig.dbUsername, DbConfig.dbPassword);
        } catch(Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        }
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT * FROM products";
            Statement statement = dbConnection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int productId = result.getInt("id");
                String name = result.getString("name");
                String category = result.getString("category");
                String gender = result.getString("gender");
                int price = result.getInt("price");
                int stock = result.getInt("stock");
                String codeScan = result.getString("codeScan");
                String image = result.getString("image");
                Product product = new Product(productId, name, category, gender, price, stock, codeScan, image);
                products.add(product);
            }

            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int id) {
        Product product = null;
        try {
            String sql = "SELECT * FROM products WHERE  id=?";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int productId = result.getInt("id");
                String productName = result.getString("name");
                String productCategory = result.getString("category");
                String productGender = result.getString("gender");
                int productPrice = result.getInt("price");
                int productStock = result.getInt("stock");
                String productCodeScan = result.getString("codeScan");
                String productImage = result.getString("image");
                product = new Product(productId, productName, productCategory, productGender, productPrice, productStock, productCodeScan, productImage);
            }

            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public Product getProductByCodeScan(String codeScan) {
        Product product = null;
        try {
            String sql = "SELECT * FROM products  WHERE  codeScan=?";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, codeScan);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int productId = result.getInt("id");
                String productName = result.getString("name");
                String productCategory = result.getString("category");
                String productGender = result.getString("gender");
                int productPrice = result.getInt("price");
                int productStock = result.getInt("stock");
                String productCodeScan = result.getString("codeScan");
                String productImage = result.getString("image");
                product = new Product(productId, productName, productCategory, productGender, productPrice, productStock, productCodeScan, productImage);
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }


    public void addNewProduct(Product newProduct) {
        try {
            String sql = "INSERT INTO products ( name,  category,  gender,  price,  stock, codeScan, image) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, newProduct.getName());
            statement.setString(2, newProduct.getCategory());
            statement.setString(3, newProduct.getGender());
            statement.setInt(4, newProduct.getPrice());
            statement.setInt(5, newProduct.getStock());
            statement.setString(6, newProduct.getCodeScan());
            statement.setString(7, newProduct.getImage());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("A new product has inserted successfully.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateProduct(int productId, Product updateProduct) {
        try {
            String sql = "UPDATE products SET name=?,  category=?, gender=?, price=?,stock=?,codeScan=?,image=? WHERE id =? ";

            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, updateProduct.getName());
            statement.setString(2, updateProduct.getCategory());
            statement.setString(3, updateProduct.getGender());
            statement.setInt(4, updateProduct.getPrice());
            statement.setInt(5, updateProduct.getStock());
            statement.setString(6, updateProduct.getCodeScan());
            statement.setString(7, updateProduct.getImage());
            statement.setInt(8, productId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been updated.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateStockById(Long id, int stock) {
        try {
            String sql = "UPDATE products SET stock=? WHERE id =? ";

            PreparedStatement statement = dbConnection.prepareStatement(sql);

            statement.setInt(2, stock);
            statement.setLong(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been updated.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteByName(String name) {
        try {
            String sql = "DELETE FROM products WHERE name =?";

            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, name);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been deleted.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            String sql = "DELETE FROM products WHERE id =?";

            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been deleted.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateProductStockByCodeScan(String codeScan, int stock) {

        try {
            String sql = "UPDATE products SET stock=? WHERE codeScan =? ";

            PreparedStatement statement = dbConnection.prepareStatement(sql);

            statement.setInt(1, stock);
            statement.setString(2, codeScan);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("the product information has been updated.");
            }
            dbConnection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
