package com.sukyky.repository;

import com.sukyky.model.Stock;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author huljas
 */
public class StockRepositoryImpl implements StockRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Stock> findAllStocks() {
        CriteriaQuery<Stock> criteriaQuery = em.getCriteriaBuilder().createQuery(Stock.class);
        criteriaQuery.from(Stock.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public void save(Stock stock) {
        em.persist(stock);
    }
}
