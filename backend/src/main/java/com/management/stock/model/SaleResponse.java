package com.management.stock.model;

public class SaleResponse {

    public String productCodeScan;
    public double totalPrice;
    public int numberOfProducts;

    public SaleResponse(String productCodeScan, double totalPrice, int numberOfProducts){
        this.productCodeScan = productCodeScan;
        this.totalPrice = totalPrice;
        this.numberOfProducts = numberOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public String getProductCodeScan() {
        return productCodeScan;
    }
}
