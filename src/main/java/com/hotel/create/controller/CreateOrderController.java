package com.hotel.create.controller;

import com.hotel.create.model.Hotel;
import com.hotel.create.service.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateOrderController {

    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody Hotel request) throws Exception {
        return createOrderService.createOrder(request) ? new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

}
