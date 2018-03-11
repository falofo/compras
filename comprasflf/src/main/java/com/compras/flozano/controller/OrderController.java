package com.compras.flozano.controller;

import com.compras.flozano.model.Order;
import com.compras.flozano.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getOrders(@PathVariable("id") int id){
        List<Order> orderList = orderService.getOrder(id);
        if (orderList.size()==0){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
    }
}
