package com.example.bp_2023_2024.services;

import com.example.bp_2023_2024.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    //TODO
}
