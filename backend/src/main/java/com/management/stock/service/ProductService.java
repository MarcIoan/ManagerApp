package com.management.stock.service;

import com.management.stock.model.Product;
import com.management.stock.repository.ProductRepository;
import java.util.ArrayList;

/**
 *
 */
public class ProductService {

    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    /**
     * Get all products
     */
    public ArrayList<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    /**
     * Get product by id
     */
    public Product getProductById(int productId) {
        return productRepository.getProductById(productId);
    }

    /**
     * Get product by code scan
     */
    public Product getProductByCodeScan(String codeScan) {
        return productRepository.getProductByCodeScan(codeScan);
    }

    /**
     * Add a new product
     */
    public void addProduct(Product newProduct) {
        productRepository.addNewProduct(newProduct);
    }

    /**
     * Delete product
     */
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }

    /**
     * Update product
     */
    public void updateProduct(int productId, Product updateProduct) {
        productRepository.updateProduct(productId, updateProduct);
    }

    /**
     * Set product stock by code scan
     */
    public void setProductStockByCodeScan(String codeScan, int stock) {
        productRepository.updateProductStockByCodeScan(codeScan, stock);
    }
}

