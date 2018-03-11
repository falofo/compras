package com.compras.flozano.service;

import com.compras.flozano.model.Order;

import java.util.List;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
public interface IOrderService {
    /**
     * Metodo para obtener lista de ordenes de acuerdo al id del cliente
     * @param customerId id del cliente
     * @return List<{@link Order}>listado de todos los clientes
     */
    List<Order> getOrder(Integer customerId);

    /**
     * Método para guardar ordenes
     * @param {@link Order}
     * @return id orden guardada
     */
    Integer saveOrder(Order order);
}

