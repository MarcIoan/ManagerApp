package com.management.stock.service;

import com.management.stock.model.Product;
import com.management.stock.repository.ProductRepository;

import java.util.ArrayList;


public class ProductService {

    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public void addProduct(String name, String category, String gender, int price, int stock, String codeScan) {
        productRepository.insert(name, category, gender, price, stock, codeScan);
    }

    public void removeProductById(int id) {
        productRepository.deleteById(id);
    }

    public void removeProductByName(String name) {
        productRepository.deleteByName(name);
    }

    public void modifyStock(Long id, int stock) {
        productRepository.updateStockById(id, stock);
    }

    public void modifyProductById(Long id, String name, String category, String gender, int price, int stock, String codeScan) {
        productRepository.updateById(id.intValue(), name, category, gender, price, stock, codeScan);
    }

    public ArrayList<Product> getAllEmploye() {
        return productRepository.selectAll();
    }

    public Product searchProduct(Long id) {
        return productRepository.selectById(id);
    }

    public Product searchProductCategory(String category) {
        return productRepository.selectByCategory(category);
    }

    public int totalStock() {
        int total = 0;
        ArrayList<Product> products = productRepository.selectAll();
        for (Product p : products) {
            total = total + p.getStock();
        }
        return total;
    }

    public Product saleProduct(String codeScan) {
        return productRepository.selectByCodeScan(codeScan);
    }


    public double pret(String codeScan) {
        Product product = productRepository.selectByCodeScan(codeScan);
        return product.getPrice();
    }


    public void modifyStockByCodeScan(String codeScan, int stock) {
        productRepository.updateStockByCodeScan(codeScan, stock);
    }
}

