package com.compras.flozano.service.impl;

import com.compras.flozano.model.Order;
import com.compras.flozano.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
@Service("orderService")
public class OrderService extends AbstractService implements IOrderService{
    public List<Order> getOrder(Integer customerId) {
        TypedQuery<Order> query = em.createNamedQuery("Order.findByCustomerId",Order.class);
        query.setParameter("customer_id",customerId);
        List<Order> lista = query.getResultList();
        return lista;
    }
}
