package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.models.OrderDetails;
import com.example.bp_2023_2024.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DetailsService {
@Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> getAllDetails() {
        return orderDetailsRepository.findAll();
    }

    public Optional<OrderDetails> getDetailById(String id) {
        return orderDetailsRepository.findById(id);
    }

    public OrderDetails createDetail(OrderDetails details) {
        return orderDetailsRepository.save(details);
    }

    public OrderDetails updateDetail(OrderDetails details) {
        return orderDetailsRepository.save(details);
    }

    public void deleteDetail(String id) {
        orderDetailsRepository.deleteById(id);
    }

public int calculateTotal(String id){
    OrderDetails details = orderDetailsRepository.findById(String.valueOf(id)).orElse(null);
    int res = Integer.parseInt(details.getTotal()) ;
    if (details != null) {
        return res = Integer.parseInt(details.getCharge()) * Integer.parseInt(details.getRealTime());
    }
    else {
        return 0;
    }
}
}


