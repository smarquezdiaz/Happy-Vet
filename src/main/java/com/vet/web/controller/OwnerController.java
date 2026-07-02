package com.vet.web.controller;

import com.vet.persistence.entity.OwnerEntity;
import com.vet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerEntity>> getAll() {
        return ResponseEntity.ok(this.ownerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.ownerService.get(id));
    }

    @PostMapping
    public ResponseEntity<OwnerEntity> add(@RequestBody OwnerEntity ownerEntity) {
        return ResponseEntity.ok(this.ownerService.save(ownerEntity));
    }
}
