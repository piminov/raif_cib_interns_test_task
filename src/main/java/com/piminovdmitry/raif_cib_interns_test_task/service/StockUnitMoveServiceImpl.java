package com.piminovdmitry.raif_cib_interns_test_task.service;

import com.piminovdmitry.raif_cib_interns_test_task.repository.StockUnitMoveRepository;
import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnitMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockUnitMoveServiceImpl implements StockUnitMoveService {
    @Autowired
    private StockUnitMoveRepository stockUnitMoveDAO;

    @Override
    @Transactional
    public void saveStockUnitMove(StockUnitMove stockUnitMove) {
        stockUnitMoveDAO.saveStockUnitMove(stockUnitMove);
    }

    @Override
    @Transactional
    public void saveStockUnitOutcome(StockUnitMove stockUnitMove) {
        stockUnitMoveDAO.saveStockUnitMove(stockUnitMove);
    }

    @Override
    @Transactional
    public List<StockUnitMove> getStockUnitMoveByParams(String color, int cottonPart, Operation operation) {
        return null;
    }
}
