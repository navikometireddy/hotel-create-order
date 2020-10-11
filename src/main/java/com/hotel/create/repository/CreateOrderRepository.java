package com.hotel.create.repository;

import com.hotel.create.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateOrderRepository extends CrudRepository<Hotel, String> {
	
}
