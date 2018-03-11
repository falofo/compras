package com.compras.flozano.service.impl;

import com.compras.flozano.model.AvailableProduct;
import com.compras.flozano.model.Product;
import com.compras.flozano.service.IProductService;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Fabiani Lozano on 11/03/2018.
 */
@Service("productService")
public class ProductService extends AbstractService implements IProductService{

    @Override
    public List<AvailableProduct> getAvailableProducts(Integer customerId) {
        TypedQuery<AvailableProduct> query = em.createNamedQuery("AvailableProduct.findByCustomerId",AvailableProduct.class);
        query.setParameter("customer_id",customerId);
        List<AvailableProduct> lista = query.getResultList();
        return lista;
    }
}
