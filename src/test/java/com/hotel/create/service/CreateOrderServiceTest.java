package com.hotel.create.service;

import com.hotel.create.model.Customer;
import com.hotel.create.model.Hotel;
import com.hotel.create.model.Room;
import com.hotel.create.repository.CreateOrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateOrderServiceTest {

    @Autowired
    public CreateOrderService createOrderService;

    @MockBean
    CreateOrderRepository createOrderRepository;

    Hotel hotel = null;
    Hotel response = null;

    @Before
    public void setup() {
        hotel= new Hotel();
        Room room= new Room();
        Customer customer=new Customer();
        hotel.setHotelId("001");
        hotel.setHotelName("TUNE");
        hotel.setCheckInDate(new Date());
        hotel.setCheckOutDate(new Date());
        customer.setCustomerName("navi");
        customer.setEmail("abc@gmail.com");
        customer.setCountry("MY");
        customer.setState("KL");
        customer.setPostalCode("57100");
        hotel.setCustomer(customer);
        room.setFloor("2");
        room.setNumberOfGuests("2");
        room.setRoomNumber("12");
        hotel.setRoom(room);

    }

    @Test
    public void createOrderTest() throws Exception {
        Mockito.when(createOrderRepository.save(hotel)).thenReturn(response);
        boolean flag = createOrderService.createOrder(hotel);
        assertEquals(true, flag);
    }

}