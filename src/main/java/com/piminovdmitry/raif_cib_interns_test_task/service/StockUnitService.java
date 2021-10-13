package com.piminovdmitry.raif_cib_interns_test_task.service;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnit;

import java.util.List;

public interface StockUnitService {
    void saveStockUnit(StockUnit stockUnit, TransactionType transactionType);

    StockUnit getStockUnitByParams(String color, int cottonPart, String operation);

}
