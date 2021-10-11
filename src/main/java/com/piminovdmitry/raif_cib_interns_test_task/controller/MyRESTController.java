package com.piminovdmitry.raif_cib_interns_test_task.controller;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnitMove;
import com.piminovdmitry.raif_cib_interns_test_task.service.StockUnitMoveService;
import com.piminovdmitry.raif_cib_interns_test_task.service.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private StockUnitMoveService stockUnitMoveService;

//    @GetMapping("/socks")
//    public int getQuantitySocksByParams(@PathVariable)

    @PostMapping("/socks/income")
    public StockUnitMove addIncome(@RequestBody StockUnitMove stockUnitMove) {
        stockUnitMove.setTransactionType(TransactionType.INCOME);
        stockUnitMoveService.saveStockUnitMove(stockUnitMove);
        return stockUnitMove;
    }

    @PostMapping("/socks/outcome")
    public StockUnitMove addOutcome(@RequestBody StockUnitMove stockUnitMove) {
        stockUnitMove.setTransactionType(TransactionType.OUTCOME);
        stockUnitMoveService.saveStockUnitOutcome(stockUnitMove);
        return stockUnitMove;
    }
}
