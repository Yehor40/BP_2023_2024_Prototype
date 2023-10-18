package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.models.OrderDetails;
import com.example.bp_2023_2024.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class DetailsService {
@Autowired
    private OrderDetailsRepository orderDetailsRepository;

//TODO
public int calculateWage(String id){
    OrderDetails details = orderDetailsRepository.findById(String.valueOf(id)).orElse(null);
    int res = Integer.parseInt(details.getTotal()) ;
    if (details != null) {
        return res = Integer.parseInt(details.getCharge()) * Integer.parseInt(details.getRealTime());
    }
    // Handle the case where the entity with the given ID is not found
    else
    return 0;
}
}


