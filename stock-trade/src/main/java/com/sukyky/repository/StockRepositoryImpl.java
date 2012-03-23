package com.sukyky.repository;

import com.sukyky.model.Holding;
import com.sukyky.model.TradeOrder;
import com.sukyky.model.Stock;
import com.sukyky.model.Trader;
import org.joda.time.LocalDate;
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

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Stock stock) {
        em.persist(stock);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Trader trader) {
        em.persist(trader);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Holding holding) {
        em.persist(holding);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public TradeOrder buy(Trader buyer, Stock stock, int price) {
        buyer = em.find(Trader.class, buyer.id);
        stock = em.find(Stock.class, stock.id);
        List<TradeOrder> tradeOrders = em.createQuery("select order from TradeOrder order where order.stock = :stock and order.priceA <= :price", TradeOrder.class)
                .setParameter("stock", stock).setParameter("price", price).getResultList();

        TradeOrder bestOffer = null;
        for (TradeOrder tradeOrder : tradeOrders) {
            if (tradeOrder.buyer == null) {
                if (bestOffer == null || tradeOrder.priceA < bestOffer.priceA) {
                    bestOffer = tradeOrder;
                }
            }
        }
        if (bestOffer == null) {
            bestOffer = new TradeOrder();
            bestOffer.buyer = buyer;
            bestOffer.priceA = price;
            bestOffer.stock = stock;
            em.persist(bestOffer);
        } else {
            bestOffer.buyer = buyer;
            bestOffer.buyer.addHolding(stock);
            bestOffer.seller.removeHolding(stock);
            bestOffer.time = new Date();
            em.merge(bestOffer);
        }
        return bestOffer;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public TradeOrder sell(Trader seller, Stock stock, int price) {
        seller = em.find(Trader.class, seller.id);
        stock = em.find(Stock.class, stock.id);
        List<TradeOrder> tradeOrders = em.createQuery("select order from TradeOrder order where order.stock = :stock and order.priceA >= :price", TradeOrder.class)
                .setParameter("stock", stock).setParameter("price", price).getResultList();

        TradeOrder bestOffer = null;
        for (TradeOrder tradeOrder : tradeOrders) {
            if (tradeOrder.seller == null) {
                if (bestOffer == null || tradeOrder.priceA > bestOffer.priceA) {
                    bestOffer = tradeOrder;
                }
            }
        }
        if (bestOffer == null) {
            bestOffer = new TradeOrder();
            bestOffer.seller = seller;
            bestOffer.priceA = price;
            bestOffer.stock = stock;
            em.persist(bestOffer);
        } else {
            bestOffer.seller = seller;
            bestOffer.buyer.addHolding(stock);
            bestOffer.seller.removeHolding(stock);
            bestOffer.time = new Date();
            em.merge(bestOffer);
        }
        return bestOffer;
    }

    public TradeOrder getLastTrade(Stock stock) {
        List<TradeOrder> prices = em.createQuery("select o from TradeOrder o where o.stock = :stock and o.buyer is not null and o.seller is not null order by o.time desc", TradeOrder.class)
                .setParameter("stock", stock).setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }

    public TradeOrder getLastTradeSince(Stock stock, Date since) {
        List<TradeOrder> prices = em.createQuery("select o from TradeOrder o where o.stock = :stock and o.buyer is not null and o.seller is not null and o.time < :since order by o.time desc", TradeOrder.class)
                .setParameter("stock", stock).setParameter("since", since)
                .setMaxResults(1).getResultList();
        if (prices.isEmpty()) return null; else return prices.get(0);
    }
}
