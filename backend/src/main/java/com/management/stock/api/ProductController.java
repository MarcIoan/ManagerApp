package com.management.stock.api;
import com.management.stock.model.Product;
import com.management.stock.service.ProductService;
import org.springframework.web.bind.annotation.*;

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
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product newProduct) {
        productService.addProduct(newProduct);
    }

    @PutMapping(value = "/products/{productId}", consumes = {"application/json"})
    public void updateProduct(@PathVariable Integer productId, @RequestBody Product updateProduct) {
        productService.updateProduct(productId, updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);
    }

}
