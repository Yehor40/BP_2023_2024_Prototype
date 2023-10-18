package com.example.bp_2023_2024.repositories;

import com.example.bp_2023_2024.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

}
