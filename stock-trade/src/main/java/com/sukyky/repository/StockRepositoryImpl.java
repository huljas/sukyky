package com.sukyky.repository;

import com.sukyky.model.*;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;

/**
 * @author huljas
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StockRepositoryImpl implements StockRepository {

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

    public StockHistory findHistory(Long stockId, LocalDate start, LocalDate end) {
        List<Object[]> results = em.createNativeQuery("select avg(price), date(time) from trade " +
                "where stock_id = :stockId " +
                "and time <= :start and " +
                "time >= :end " +
                "group by date(time) order by date(time)")
                .setParameter("stockId", stockId)
                .setParameter("start", start.toDateTimeAtStartOfDay().toDate())
                .setParameter("end", end.toDateTimeAtStartOfDay().toDate())
                .getResultList();
        return new StockHistory(results);
    }

    public int getOpeningPrice(Stock stock) {
        Trade last = getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        Trade opening = getFirstTradeAfter(stock, since);
        return opening.price;
    }

    public int getClosingPrice(Stock stock) {
        Trade last = getLastTrade(stock);
        Date since = new LocalDate(last.time).toDateTimeAtStartOfDay().toDate();
        Trade closing = getLastTradeBefore(stock, since);
        return closing.price;
    }

    public int getLastPrice(Stock stock) {
        return getLastTrade(stock).price;
    }

    public int getDailyMin(Stock stock) {
        return getMin(stock, 1);
    }

    public int getDailyMax(Stock stock) {
        return getMax(stock, 1);
    }

    public int getYearlyMin(Stock stock) {
        return getMin(stock, 7*52);
    }

    public int getYearlyMax(Stock stock) {
        return getMax(stock, 7*52);
    }

    // Helper queries

    protected Trade getLastTrade(Stock stock) {
        List<Trade> prices = em.createQuery("select o from Trade o where o.stock = :stock order by o.time desc", Trade.class)
                .setParameter("stock", stock).setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }

    protected Trade getLastTradeBefore(Stock stock, Date since) {
        List<Trade> prices = em.createQuery("select o from Trade o where o.stock = :stock and o.time < :since order by o.time desc", Trade.class)
                .setParameter("stock", stock).setParameter("since", since)
                .setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }

    protected Trade getFirstTradeAfter(Stock stock, Date since) {
        List<Trade> prices = em.createQuery("select o from Trade o where o.stock = :stock and o.time > :since order by o.time asc", Trade.class)
                .setParameter("stock", stock).setParameter("since", since)
                .setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }


    protected int getMin(Stock stock, int days) {
        Trade order = getLastTrade(stock);
        Date end = order.time;
        Date start = new LocalDateTime(end).minusDays(days).toDateTime().toDate();
        return em.createQuery("select min(o.price) " +
                "from Trade o " +
                "where o.stock = :stock " +
                "and o.time >= :start " +
                "and o.time <= :end", Integer.class)
                .setParameter("stock", stock).setParameter("start", start).setParameter("end", end).getSingleResult();
    }

    protected int getMax(Stock stock, int days) {
        Trade order = getLastTrade(stock);
        Date end = order.time;
        Date start = new LocalDateTime(end).minusDays(days).toDateTime().toDate();
        return em.createQuery("select max(o.price) " +
                "from Trade o " +
                "where o.stock = :stock " +
                "and o.time >= :start " +
                "and o.time <= :end", Integer.class)
                .setParameter("stock", stock).setParameter("start", start).setParameter("end", end).getSingleResult();
    }
}
