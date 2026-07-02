package com.vet.web.controller;

import com.vet.service.PetService;
import com.vet.service.dto.CreatePetRequest;
import com.vet.service.dto.PetResponse;
import com.vet.service.dto.UpdatePetRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<PetResponse>> getAll() {
        return ResponseEntity.ok(this.petService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a pet by Id",
            description = "Returns a pet with the same Id that was sent",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pet found"),
                    @ApiResponse(responseCode = "404", description = "Pet not found", content = @Content),
            }
    )
    public ResponseEntity<PetResponse> getById(@PathVariable Long id) {
        PetResponse petResponse = this.petService.getById(id);

        if (petResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(petResponse);
    }

    @PostMapping
    public ResponseEntity<PetResponse> add(@RequestBody CreatePetRequest pet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.petService.save(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetResponse> update(@RequestBody @Valid UpdatePetRequest pet, @PathVariable Long id) {
        return ResponseEntity.ok(this.petService.update(pet, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (this.petService.exists(id)) {
            this.petService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
