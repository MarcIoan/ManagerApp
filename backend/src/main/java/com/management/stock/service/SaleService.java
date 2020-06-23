package com.management.stock.service;

import com.management.stock.model.Product;
import com.management.stock.model.SaleResponse;

public class SaleService {

    private ProductService productService;

    public SaleService() {
        this.productService = new ProductService();
    }

    public SaleResponse sellProduct(String codeScan, int numberOfProducts) {
        // Get the product by codeScan
        Product product = productService.getProductByCodeScan(codeScan);
        // Decrease the stock(if it is possible)
        int decreasesStock;
        if(product.getStock() >= numberOfProducts){
            decreasesStock = product.getStock() - numberOfProducts;
        } else {
            throw new RuntimeException("Product stock is not available");
        }
        // Set the new stock
        productService.setProductStockByCodeScan(codeScan,decreasesStock);
        // Get the total price
        double totalPrice = product.getPrice() * numberOfProducts;
        // Create a response that contains the product code scan, total price and number of products
        SaleResponse saleResponse = new SaleResponse(codeScan, totalPrice, numberOfProducts);
        return saleResponse;
    }
}

