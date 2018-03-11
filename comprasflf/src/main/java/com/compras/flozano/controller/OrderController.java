package com.compras.flozano.controller;

import com.compras.flozano.model.Order;
import com.compras.flozano.model.OrderDetail;
import com.compras.flozano.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    /**
     * Método para obtener ordenes de acuerdo al id del cliente
     * @param customerId id del cliente
     * @return lista de ordenes
     */
    @RequestMapping(value = "/{customerId}",method = RequestMethod.GET)
    public ResponseEntity<?> getOrders(@PathVariable("customerId") int customerId){
        List<Order> orderList = orderService.getOrder(customerId);
        if (orderList.size()==0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    /**
     * Método para guardar ordenes
     * @param order {@link Order} a guardar
     * @return id orden guardada
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@RequestBody Order order){
        Integer idOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(idOrder,HttpStatus.OK);
    }
}
