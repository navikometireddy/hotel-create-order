package com.hotel.create.controller;

import com.hotel.create.dto.HotelResponse;
import com.hotel.create.model.Hotel;
import com.hotel.create.service.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreateOrderController {

    @Autowired
    private CreateOrderService createOrderService;

    /**
     * this method will create order
     *
     * @param request
     * @return HotelResponse
     * @throws Exception
     */
    @PostMapping("/createOrder")
    public HotelResponse createOrder(@Valid @RequestBody Hotel request) throws Exception {
        return createOrderService.createOrder(request) ?
                HotelResponse.builder()
                        .statusCode("100")
                        .statusMessage("Success")
                        .hotel(HotelResponse.Hotel.builder()
                                .hotelId(request.getHotelId())
                                .hotelName(request.getHotelName())
                                .checkInDate(request.getCheckInDate())
                                .checkOutDate(request.getCheckOutDate())
                                .build()).build()
                : HotelResponse.builder()
                .statusCode("400")
                .statusMessage("Fail").build();
    }

}
