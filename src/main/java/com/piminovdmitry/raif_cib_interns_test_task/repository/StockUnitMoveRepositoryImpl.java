package com.piminovdmitry.raif_cib_interns_test_task.repository;

import com.piminovdmitry.raif_cib_interns_test_task.entity.StockUnitMove;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StockUnitMoveRepositoryImpl implements StockUnitMoveRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StockUnitMove> getStockUnitMovesByParams() {
        Session session = entityManager.unwrap(Session.class);
        Query<StockUnitMove> query = session.createQuery("from StockUnitMove",StockUnitMove.class);
        List<StockUnitMove> listStockChanges = query.getResultList();

        return null;
    }

    @Override
    public void saveStockUnitMove(StockUnitMove stockUnitMove) {
        Session session = entityManager.unwrap(Session.class);
        session.save(stockUnitMove);
    }
}
