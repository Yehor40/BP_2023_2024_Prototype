package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.models.Task_Details;
import com.example.bp_2023_2024.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DetailsService {
@Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<Task_Details> getAllDetails() {
        return orderDetailsRepository.findAll();
    }

    public Optional<Task_Details> getDetailById(Long id) {
        return orderDetailsRepository.findById(id);
    }

    public Task_Details createDetail(Task_Details details) {
        return orderDetailsRepository.save(details);
    }

    public Task_Details updateDetail(Task_Details details) {
        return orderDetailsRepository.save(details);
    }

    public void deleteDetail(Long id) {
        orderDetailsRepository.deleteById(id);
    }

public int calculateTotal(Long id){
    Task_Details details = orderDetailsRepository.findById(id).orElse(null);
    int res = Integer.parseInt(details.getTotal()) ;
    if (details != null) {
        return res = Integer.parseInt(details.getCharge()) * Integer.parseInt(details.getRealTime());
    }
    else {
        return 0;
    }
}
}


