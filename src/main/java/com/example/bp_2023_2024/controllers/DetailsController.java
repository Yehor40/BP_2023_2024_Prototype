package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.OrderDetails;
import com.example.bp_2023_2024.models.TaskDepartment;
import com.example.bp_2023_2024.services.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/details")
public class DetailsController {
    @Autowired
    private DetailsService details;
    @GetMapping("getDetails")
    public List<OrderDetails> getAllDetails() {
        return details.getAllDetails();
    }
    @GetMapping("getDetail/{id}")
    public ResponseEntity<OrderDetails> getDetailById(@PathVariable String id) {
        Optional<OrderDetails> detail = details.getDetailById(id);
        return detail.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="createDetail",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDetails> createTask(@RequestBody OrderDetails detail) {
        OrderDetails newDetail = details.createDetail(detail);
        return ResponseEntity.ok(newDetail);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<OrderDetails> updateDetail(@PathVariable Long id, @RequestBody OrderDetails detail) {
        if (!detail.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        OrderDetails updatedDetail = details.updateDetail(detail);
        return ResponseEntity.ok(updatedDetail);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        details.deleteDetail(id);
        return ResponseEntity.noContent().build();
    }
}
