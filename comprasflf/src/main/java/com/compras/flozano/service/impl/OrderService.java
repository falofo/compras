package com.compras.flozano.service.impl;

import com.compras.flozano.model.Order;
import com.compras.flozano.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.TypedQuery;
import javax.transaction.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
@Service("orderService")
public class OrderService extends AbstractService implements IOrderService {

    public List<Order> getOrder(Integer customerId, Date startDate, Date endDate) {
        TypedQuery<Order> query = em.createNamedQuery("Order.findByCustomerId", Order.class);
        query.setParameter("customer_id", customerId);
        query.setParameter("start_date", startDate);
        query.setParameter("end_date", endDate);
        List<Order> lista = query.getResultList();
        return lista;
    }

    @Override
    @Transactional
    public Integer saveOrder(Order order) {
        em.persist(order);
        em.flush();
        return order.getOrderId();
    }
}
