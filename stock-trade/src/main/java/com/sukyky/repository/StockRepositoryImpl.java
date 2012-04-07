package com.sukyky.repository;

import com.sukyky.model.*;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Calendar;
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
        Trade order = getLastTrade(stock);
        Date start = minusDays(order.time, 1);
        return getMin(stock, start);
    }

    public int getDailyMax(Stock stock) {
        Trade order = getLastTrade(stock);
        Date start = minusDays(order.time, 1);
        return getMax(stock, start);
    }

    public int getYearlyMin(Stock stock) {
        Trade order = getLastTrade(stock);
        Date start = minusDays(order.time, 365);
        return getMin(stock, start);
    }

    public int getYearlyMax(Stock stock) {
        Trade order = getLastTrade(stock);
        Date start = minusDays(order.time, 365);
        return getMax(stock, start);
    }

    public Date getLastTime(Stock stock) {
        return getLastTrade(stock).time;
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


    protected int getMin(Stock stock, Date start) {
        Integer result = em.createQuery("select min(o.price) " +
                "from Trade o " +
                "where o.stock = :stock " +
                "and o.time >= :start", Integer.class)
                .setParameter("stock", stock).setParameter("start", start).getSingleResult();
        return result;
    }

    protected int getMax(Stock stock, Date start) {
        Integer result = em.createQuery("select max(o.price) " +
                "from Trade o " +
                "where o.stock = :stock " +
                "and o.time >= :start", Integer.class)
                .setParameter("stock", stock).setParameter("start", start).getSingleResult();
        return result;
    }

    public static Date minusDays(Date now, int days) {
        Calendar last = Calendar.getInstance();
        last.setTime(now);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, last.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.MONTH, last.get(Calendar.MONTH));
        calendar.set(Calendar.YEAR, last.get(Calendar.YEAR));
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }
}
