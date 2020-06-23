package com.management.stock.api;

import com.management.stock.service.SaleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SaleController {


    private SaleService saleService;

    SaleController() {
        saleService = new SaleService();
    }


    @PutMapping("/sale")
    public String getSale(@RequestParam String codeScan, @RequestParam int numberOfProducts) {
        return saleService.searchProductByCodeScan(codeScan, numberOfProducts);
    }
}
