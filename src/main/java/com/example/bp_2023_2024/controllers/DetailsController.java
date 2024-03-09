package com.example.bp_2023_2024.controllers;

import com.example.bp_2023_2024.models.Task_Details;
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
    public List<Task_Details> getAllDetails() {
        return details.getAllDetails();
    }
    @GetMapping("getDetail/{id}")
    public ResponseEntity<Task_Details> getDetailById(@PathVariable Long id) {
        Optional<Task_Details> detail = details.getDetailById(id);
        return detail.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path="createDetail",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task_Details> createTask(@RequestBody Task_Details detail) {
        Task_Details newDetail = details.createDetail(detail);
        return ResponseEntity.ok(newDetail);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Task_Details> updateDetail(@PathVariable Long id, @RequestBody Task_Details detail) {
        if (!detail.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Task_Details updatedDetail = details.updateDetail(detail);
        return ResponseEntity.ok(updatedDetail);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        details.deleteDetail(id);
        return ResponseEntity.noContent().build();
    }
}
