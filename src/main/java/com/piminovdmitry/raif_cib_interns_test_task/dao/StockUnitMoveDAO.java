package com.piminovdmitry.raif_cib_interns_test_task.dao;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnitMove;

import java.util.List;

public interface StockUnitMoveDAO {
    public List<StockUnitMove> getStockUnitMovesByParams();

    public void saveStockUnitMove(StockUnitMove stockUnitMove);

}
