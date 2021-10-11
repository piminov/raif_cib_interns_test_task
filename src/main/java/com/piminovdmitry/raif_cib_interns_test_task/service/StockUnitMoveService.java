package com.piminovdmitry.raif_cib_interns_test_task.service;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnitMove;

import java.util.List;

public interface StockUnitMoveService {
    void saveStockUnitMove(StockUnitMove stockUnitMove);

    void saveStockUnitOutcome(StockUnitMove stockUnitMove);

    List<StockUnitMove> getStockUnitMoveByParams(String color, int cottonPart, CompOperation operation);

}
