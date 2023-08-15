package com.example.bp_2023_2024.repositories;

import com.example.bp_2023_2024.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {
}
