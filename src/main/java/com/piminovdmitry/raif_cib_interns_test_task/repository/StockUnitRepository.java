package com.piminovdmitry.raif_cib_interns_test_task.repository;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnit;

import java.util.List;

public interface StockUnitRepository {
    StockUnit getStockUnitByParams(String color, int cottonPart, String operator);

    void saveOrUpdateStockUnit(StockUnit stockUnit);

}
