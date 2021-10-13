package com.piminovdmitry.raif_cib_interns_test_task.controller;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnit;
import com.piminovdmitry.raif_cib_interns_test_task.service.StockUnitService;
import com.piminovdmitry.raif_cib_interns_test_task.service.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SocksController {

    @Autowired
    private StockUnitService stockUnitService;

    @GetMapping("/socks")
    public int getQuantitySocksByParams(@RequestParam("color") String color,
                                        @RequestParam("operation") String operation,
                                        @RequestParam("cottonPart") int cottonPart) {
        StockUnit stockUnit = stockUnitService.getStockUnitByParams(color, cottonPart, operation);
        return stockUnit.getQuantity();
    }

    @PostMapping("/socks/income")
    public void addIncome(@RequestBody StockUnit stockUnit) {
        stockUnitService.saveStockUnit(stockUnit, TransactionType.INCOME);

    }

    @PostMapping("/socks/outcome")
    public void addOutcome(@RequestBody StockUnit stockUnit) {
        stockUnitService.saveStockUnit(stockUnit, TransactionType.OUTCOME);

    }
}
