package com.management.stock.service;

public class SaleService {
   private ProductService productService;


    public SaleService() {
        this.productService = new ProductService();
    }


    public String saleProduct(String codeScan, int numberOfProducts) {
        int decreasesStock = productService.saleProduct(codeScan).getStock() - numberOfProducts;
        productService.saleProduct(codeScan).setStock(decreasesStock);
        double totalAmount =  productService.pret(codeScan) * numberOfProducts;
        return " For these products " + codeScan + "  Total amount is : " + totalAmount;
    }

}

