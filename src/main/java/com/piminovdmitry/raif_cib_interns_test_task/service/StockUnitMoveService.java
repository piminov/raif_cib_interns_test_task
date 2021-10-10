package com.piminovdmitry.raif_cib_interns_test_task.service;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnitMove;

import java.util.List;

public interface StockUnitMoveService {
    public void saveStockUnitMove(StockUnitMove stockUnitMove);

    public void saveStockUnitOutcome(StockUnitMove stockUnitMove);

    public List<StockUnitMove> getStockUnitMoveByParams(String color, int cottonPart, Operation operation);

}
