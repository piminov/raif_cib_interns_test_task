package com.piminovdmitry.raif_cib_interns_test_task.repository;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnitMove;

import java.util.List;

public interface StockUnitMoveRepository {
    List<StockUnitMove> getStockUnitMovesByParams();

    void saveStockUnitMove(StockUnitMove stockUnitMove);

}
