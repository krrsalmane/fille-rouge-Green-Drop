package com.greendrop.controller;

import com.greendrop.dto.AgriculteurDTO;
import com.greendrop.service.AgriculteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agriculteurs")
public class AgriculteurController {

    @Autowired
    private AgriculteurService agriculteurService;

    @GetMapping
    public ResponseEntity<List<AgriculteurDTO>> getAllAgriculteurs() {
        List<AgriculteurDTO> agriculteurs = agriculteurService.getAllAgriculteurs();
        return ResponseEntity.ok(agriculteurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgriculteurDTO> getAgriculteurById(@PathVariable Long id) {
        return agriculteurService.getAgriculteurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgriculteurDTO> createAgriculteur(@RequestBody AgriculteurDTO agriculteurDTO) {
        AgriculteurDTO createdAgriculteur = agriculteurService.createAgriculteur(agriculteurDTO);
        return new ResponseEntity<>(createdAgriculteur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgriculteurDTO> updateAgriculteur(@PathVariable Long id, @RequestBody AgriculteurDTO agriculteurDTO) {
        return agriculteurService.updateAgriculteur(id, agriculteurDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgriculteur(@PathVariable Long id) {
        if (agriculteurService.deleteAgriculteur(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
