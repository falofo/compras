package com.compras.flozano.controller;

import com.compras.flozano.model.Customer;
import com.compras.flozano.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Fabiani Lozano on 11/03/2018.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    /**
     * Método para obtener clientes
     * @return List<{@link Customer}>listado de todos los clientes
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getCustomers(){
        List<Customer> customerList = customerService.getCustomers();
        if (customerList.size()==0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }
}
