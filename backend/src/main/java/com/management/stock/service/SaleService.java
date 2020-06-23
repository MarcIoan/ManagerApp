package com.management.stock.service;

public class SaleService {

    private ProductService productService;

    public SaleService() {
        this.productService = new ProductService();
    }

    public String searchProductByCodeScan(String codeScan, int numberOfProducts) {
        int decreasesStock = productService.selectProductByCodeScan(codeScan).getStock() - numberOfProducts;
        productService.modifyStockByCodeScan(codeScan,decreasesStock);
        double totalAmount = productService.pret(codeScan) * numberOfProducts;
        return "CodeScan " + codeScan + "NumberofProducts " + productService.selectProductByCodeScan(codeScan);

    }

}

