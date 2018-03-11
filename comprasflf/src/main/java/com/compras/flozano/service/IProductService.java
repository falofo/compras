package com.compras.flozano.service;

import com.compras.flozano.model.AvailableProduct;
import com.compras.flozano.model.Product;

import java.util.List;

/**
 * Created by Fabiani Lozano on 11/03/2018.
 */
public interface IProductService {

    /**
     * Método para obtener productos habilitados por cliente
     * @param customerId id del cliente
     * @return List<{@link AvailableProduct}>listado de productos
     */
    List<AvailableProduct> getAvailableProducts(Integer customerId);
}
