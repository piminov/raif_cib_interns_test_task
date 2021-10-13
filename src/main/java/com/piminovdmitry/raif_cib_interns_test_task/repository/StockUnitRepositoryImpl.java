package com.piminovdmitry.raif_cib_interns_test_task.repository;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StockUnitRepositoryImpl implements StockUnitRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public StockUnit getStockUnitByParams(String color, int cottonPart, String operator) {
        Query query = entityManager.createQuery("from StockUnit " +
                "where color =:color and cotton_part " + operator + ":cottonPart");
        query.setParameter("color", color);
        query.setParameter("cottonPart", cottonPart);
        List<StockUnit> stockUnits = query.getResultList();

        if (stockUnits.size() == 0) {
            return null;
        } else {
            return stockUnits.get(0);
        }
    }

    @Override
    public void saveOrUpdateStockUnit(StockUnit stockUnit) {
        entityManager.merge(stockUnit);
    }
}
