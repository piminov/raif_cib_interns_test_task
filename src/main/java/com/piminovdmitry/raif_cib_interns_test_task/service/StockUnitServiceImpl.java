package com.piminovdmitry.raif_cib_interns_test_task.service;

import com.piminovdmitry.raif_cib_interns_test_task.repository.StockUnitRepository;
import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockUnitServiceImpl implements StockUnitService {
    @Autowired
    private StockUnitRepository stockUnitRepository;

    @Override
    @Transactional
    public void saveStockUnit(StockUnit stockUnit, TransactionType transactionType) {
        StockUnit storedUnitStock = getStockUnitByParams(stockUnit.getColor(), stockUnit.getCottonPart(), "equal");

        if (transactionType == TransactionType.INCOME) {
            if (storedUnitStock == null) {
                stockUnitRepository.saveOrUpdateStockUnit(stockUnit);
            } else {
                storedUnitStock.setQuantity(storedUnitStock.getQuantity() + stockUnit.getQuantity());
                stockUnitRepository.saveOrUpdateStockUnit(storedUnitStock);
            }
        } else {
            if (storedUnitStock != null && storedUnitStock.getQuantity() >= stockUnit.getQuantity()) {
                storedUnitStock.setQuantity(storedUnitStock.getQuantity() - stockUnit.getQuantity());
                stockUnitRepository.saveOrUpdateStockUnit(storedUnitStock);
            } else {

            }
        }
    }

    @Override
    @Transactional
    public StockUnit getStockUnitByParams(String color, int cottonPart, String operation) {
        String newOperator;
        if (operation.equals("moreThan")) {
            newOperator = ">";
        } else if (operation.equals("lessThan")) {
            newOperator = "<";
        } else {
            newOperator = "=";
        }
        return stockUnitRepository.getStockUnitByParams(color, cottonPart, newOperator);
    }
}
