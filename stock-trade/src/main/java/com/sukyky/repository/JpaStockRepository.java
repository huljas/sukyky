package com.sukyky.repository;

import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.model.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;

@Jamon("Repository")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JpaStockRepository implements StockRepository{

    @PersistenceContext
    private EntityManager em;

    public List<Stock> findAllStocks() {
        CriteriaQuery<Stock> criteriaQuery = em.getCriteriaBuilder().createQuery(Stock.class);
        criteriaQuery.from(Stock.class);
        List<Stock> stocks = em.createQuery(criteriaQuery).getResultList();
        return stocks;
    }

    public Stock getStock(Long id) {
        return em.find(Stock.class, id);
    }

    @Cacheable("stockRepository")
    public Object[] findHistory(Long id, Date start, Date end) {
        List<Object[]> results = em.createNativeQuery("select avg(price), date(time) from trade " +
                "where stock_id = :id " +
                "and time <= :end and " +
                "time >= :start " +
                "group by date(time) order by date(time)")
                .setParameter("id", id)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
        Date[] dates = new Date[results.size()];
        int[] prices = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            Object[] result = results.get(i);
            prices[i] = ((Number)result[0]).intValue();
            dates[i] = (Date) result[1];
        }
        return new Object[]{prices, dates};
    }

    public Trade getLastTrade(Long id) {
        List<Trade> prices = em.createQuery("select o from Trade o where o.stock.id = :stock order by o.time desc", Trade.class)
                .setParameter("stock", id).setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }

    public Trade getLastTradeBefore(Long id, Date since) {
        List<Trade> prices = em.createQuery("select o from Trade o where o.stock.id = :stock and o.time < :since order by o.time desc", Trade.class)
                .setParameter("stock", id).setParameter("since", since)
                .setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }

    public Trade getFirstTradeAfter(Long id, Date since) {
        List<Trade> prices = em.createQuery("select o from Trade o where o.stock.id = :stock and o.time > :since order by o.time asc", Trade.class)
                .setParameter("stock", id).setParameter("since", since)
                .setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }

    public int getMin(Long id, Date start) {
        Integer result = em.createQuery("select min(o.price) " +
                "from Trade o " +
                "where o.stock.id = :stock " +
                "and o.time >= :start", Integer.class)
                .setParameter("stock", id).setParameter("start", start).getSingleResult();
        return result;
    }

    public int getMax(Long id, Date start) {
        Integer result = em.createQuery("select max(o.price) " +
                "from Trade o " +
                "where o.stock.id = :stock " +
                "and o.time >= :start", Integer.class)
                .setParameter("stock", id).setParameter("start", start).getSingleResult();
        return result;
    }
}
