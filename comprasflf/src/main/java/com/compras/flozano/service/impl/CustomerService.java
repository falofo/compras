package com.compras.flozano.service.impl;

import com.compras.flozano.model.Customer;
import com.compras.flozano.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Fabiani Lozano on 11/03/2018.
 */
@Service("customerService")
public class CustomerService extends AbstractService implements ICustomerService{
    @Override
    public List<Customer> getCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll",Customer.class);
        List<Customer> lista = query.getResultList();
        return lista;
    }
}
