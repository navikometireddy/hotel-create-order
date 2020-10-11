package com.hotel.create.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.create.model.Customer;
import com.hotel.create.model.Hotel;
import com.hotel.create.model.Room;
import com.hotel.create.service.CreateOrderService;
import com.hotel.create.utils.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CreateOrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreateOrderService createOrderService;

	Hotel hotel = null;

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
	public void createFeature() throws Exception {

		Mockito.when(createOrderService.createOrder(hotel)).thenReturn(true);

		mockMvc.perform(post("/createOrder").contentType(MediaType.APPLICATION_JSON).content(toJson(hotel))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}


	public static String toJson(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(final String json, Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}