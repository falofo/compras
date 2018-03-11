package com.compras.flozano.service;

import com.compras.flozano.model.Order;

import java.util.List;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
public interface IOrderService {
    /**
     * Metodo para obtener lista de ordenes de acuerdo al id del cliente
     * @param customerId
     * @return
     */
    List<Order> getOrder(Integer customerId);
}

