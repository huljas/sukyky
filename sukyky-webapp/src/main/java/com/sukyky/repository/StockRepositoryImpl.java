package com.sukyky.repository;

import com.sukyky.model.Holding;
import com.sukyky.model.Order;
import com.sukyky.model.Stock;
import com.sukyky.model.Trader;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collections;
import java.util.Comparator;
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
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Stock stock) {
        em.persist(stock);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void buy(Trader buyer, Stock stock, int price) {
        List<Order> orders = em.createQuery("select order from Order order where order.stock = :stock and order.priceA <= :price", Order.class)
                .setParameter("stock", stock).setParameter("price", price).getResultList();
        
        Order bestOffer = null;
        for (Order order : orders) {
            if (order.buyer == null) {
                if (bestOffer == null || order.priceA < bestOffer.priceA) {
                    bestOffer = order;                   
                }
            }
        }
        if (bestOffer == null) {
            bestOffer = new Order();
            bestOffer.buyer = buyer;
            bestOffer.priceA = price;
            bestOffer.stock = stock;
            em.persist(bestOffer);
        } else {
            bestOffer.buyer = buyer;
            bestOffer.buyer.addHolding(stock);
            bestOffer.seller.removeHolding(stock);
            em.merge(bestOffer);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void sell(Trader seller, Stock stock, int price) {
        List<Order> orders = em.createQuery("select order from Order order where order.stock = :stock and order.priceA >= :price", Order.class)
                .setParameter("stock", stock).setParameter("price", price).getResultList();

        Order bestOffer = null;
        for (Order order : orders) {
            if (order.buyer == null) {
                if (bestOffer == null || order.priceA > bestOffer.priceA) {
                    bestOffer = order;
                }
            }
        }
        if (bestOffer == null) {
            bestOffer = new Order();
            bestOffer.seller = seller;
            bestOffer.priceA = price;
            bestOffer.stock = stock;
            em.persist(bestOffer);
        } else {
            bestOffer.seller = seller;
            bestOffer.buyer.addHolding(stock);
            bestOffer.seller.removeHolding(stock);
            em.merge(bestOffer);
        }
    }
    
}
