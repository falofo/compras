package com.compras.flozano.controller;

import com.compras.flozano.model.AvailableProduct;
import com.compras.flozano.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Fabiani Lozano on 11/03/2018.
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    IProductService productService;

    /**
     * Método para obtener productos habilitados por cliente
     * @param customerId id del cliente
     * @return List<{@link AvailableProduct}>listado de productos
     */
    @RequestMapping(value = "/{customerId}",method = RequestMethod.GET)
    public ResponseEntity<?> getProducts(@PathVariable("customerId") int customerId){
        List<AvailableProduct> productList = productService.getAvailableProducts(customerId);
        if (productList.size()==0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }
}
