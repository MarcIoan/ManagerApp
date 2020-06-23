package com.management.stock.api;
import com.management.stock.model.Product;
import com.management.stock.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController() {
        productService = new ProductService();
    }

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return productService.getAllEmploye();
    }

    @PostMapping("/products")
    public void postProduct(@RequestBody Product p) {
        productService.addProduct(p.getName(), p.getCategory(), p.getGender(), p.getPrice(), p.getStock(), p.getCodeScan(), p.getImage());
    }

    @PutMapping(value = "/products/{id}", consumes = {"application/json"})
    public void putProduct(@PathVariable Long id, @RequestBody Product p) {
        productService.modifyProductById(id, p.getName(), p.getCategory(), p.getGender(), p.getPrice(), p.getStock(), p.getCodeScan(), p.getImage());
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.removeProductById(id.intValue());
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.searchProduct(id);
    }

}
