package com.management.stock.api;

import com.management.stock.model.SaleResponse;
import com.management.stock.service.SaleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SaleController {

    private SaleService saleService;

    SaleController() {
        saleService = new SaleService();
    }

    @PutMapping("/sales")
    public SaleResponse getSale(@RequestParam String codeScan, @RequestParam int numberOfProducts) {
        return saleService.sellProduct(codeScan, numberOfProducts);
    }
}
