package com.hotel.create.service.impl;

import com.hotel.create.model.Hotel;
import com.hotel.create.repository.CreateOrderRepository;
import com.hotel.create.service.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOrderServiceImpl implements CreateOrderService {

    @Autowired
    private CreateOrderRepository createOrderRepository;


    @Transactional
    public boolean createOrder(Hotel req) throws Exception {
        try {
            Hotel saved = createOrderRepository.save(req);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error occurred while saving the order");
        }
    }

}
