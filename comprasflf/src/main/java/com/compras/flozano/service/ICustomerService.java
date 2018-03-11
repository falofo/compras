package com.compras.flozano.service;

import com.compras.flozano.model.Customer;

import java.util.List;

/**
 * Created by Fabiani Lozano on 11/03/2018.
 */
public interface ICustomerService {
    /**
     * Metodo para obtener lista de clientes
     * @return List<{@link Customer}>listado de todos los clientes
     */
    List<Customer> getCustomers();
}
