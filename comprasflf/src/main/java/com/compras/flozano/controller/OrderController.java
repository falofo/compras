package com.compras.flozano.controller;

import com.compras.flozano.model.Order;
import com.compras.flozano.model.OrderDetail;
import com.compras.flozano.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Controlador que expone servicio para obtener órdenes y guardar órdenes
 * Created by Fabiani Lozano on 10/03/2018.
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    /**
     * Método para obtener órdenes de acuerdo al id del cliente
     *
     * @param customerId id del cliente
     * @param startDateStr Fecha de inicio de consulta
     * @param endDateStr Fecha de fin de consulta
     * @return lista de ordenes
     */
    @RequestMapping(value = "/{customerId}/{startDate}/{endDate}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrders(@PathVariable("customerId") int customerId,
                                       @PathVariable("startDate") String startDateStr,
                                       @PathVariable("endDate") String endDateStr) {
        Date startDate;
        Date endDate;
        try {
            startDate = new SimpleDateFormat("yyyyMMdd").parse(startDateStr);
            endDate = new SimpleDateFormat("yyyyMMdd").parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        List<Order> orderList = orderService.getOrder(customerId,startDate,endDate);
        if (orderList.size() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    /**
     * Método para guardar órdenes
     *
     * @param order {@link Order} a guardar
     * @return id orden guardada
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@RequestBody Order order) {
        if (order != null && order.getDetalle() != null && order.getDetalle().size() > 0) {
            int productQuantity = 0;
            for(OrderDetail det : order.getDetalle()){
                productQuantity += det.getQuantity();
            }
            if(productQuantity > 5){
                return new ResponseEntity("La cantidad total de unidades de producto no debe ser mayor a 5", HttpStatus.BAD_REQUEST);
            }
        }
        Integer idOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(idOrder, HttpStatus.OK);
    }
}
