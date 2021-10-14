package com.piminovdmitry.raif_cib_interns_test_task.controller;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnit;
import com.piminovdmitry.raif_cib_interns_test_task.exception_handling.IncorrectRequestException;
import com.piminovdmitry.raif_cib_interns_test_task.exception_handling.NoSufficientSocksException;
import com.piminovdmitry.raif_cib_interns_test_task.service.CompOperation;
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
    public int getQuantitySocksUnitByParams(@RequestParam("color") String color,
                                        @RequestParam("operation") String operation,
                                        @RequestParam("cottonPart") int cottonPart) {
        CompOperation compOperation;
        try {
            compOperation = CompOperation.getEnum(operation);
        } catch (Exception e) {
            throw new IncorrectRequestException();
        }
        if (cottonPart < 0 || cottonPart > 100) {
            throw new IncorrectRequestException();
        }
        return stockUnitService.getQuantitySocksUnitByParams(color, cottonPart, compOperation);
    }

    @PostMapping("/socks/income")
    public void addIncome(@RequestBody StockUnit stockUnit) {
        System.out.println(stockUnit.toString());
        if (stockUnit.Incorrect()) {
            throw new IncorrectRequestException();
        }
        stockUnitService.saveStockUnitMove(stockUnit, TransactionType.INCOME);
    }

    @PostMapping("/socks/outcome")
    public void addOutcome(@RequestBody StockUnit stockUnit) {
        if (stockUnit.Incorrect()) {
            throw new IncorrectRequestException();
        }
        StockUnit savedStockUnit = stockUnitService.saveStockUnitMove(stockUnit, TransactionType.OUTCOME);
        if (savedStockUnit == null) {
            throw new NoSufficientSocksException();
        }
    }
}
