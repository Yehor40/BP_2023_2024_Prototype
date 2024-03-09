package com.example.bp_2023_2024.repositories;

import com.example.bp_2023_2024.models.Task_Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<Task_Details, Long> {

}
