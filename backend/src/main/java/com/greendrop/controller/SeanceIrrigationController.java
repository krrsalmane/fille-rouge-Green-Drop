package com.greendrop.controller;

import com.greendrop.dto.SeanceIrrigationDTO;
import com.greendrop.service.SeanceIrrigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seanceIrrigations")
public class SeanceIrrigationController {

    @Autowired
    private SeanceIrrigationService seanceIrrigationService;

    @GetMapping
    public ResponseEntity<List<SeanceIrrigationDTO>> getAllSeanceIrrigations() {
        List<SeanceIrrigationDTO> seanceIrrigations = seanceIrrigationService.getAllSeanceIrrigations();
        return ResponseEntity.ok(seanceIrrigations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeanceIrrigationDTO> getSeanceIrrigationById(@PathVariable Long id) {
        return seanceIrrigationService.getSeanceIrrigationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<SeanceIrrigationDTO> createSeanceIrrigation(@RequestBody SeanceIrrigationDTO seanceIrrigationDTO) {
        SeanceIrrigationDTO createdSeanceIrrigation = seanceIrrigationService.createSeanceIrrigation(seanceIrrigationDTO);
        return new ResponseEntity<>(createdSeanceIrrigation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeanceIrrigationDTO> updateSeanceIrrigation(@PathVariable Long id, @RequestBody SeanceIrrigationDTO seanceIrrigationDTO) {
        return seanceIrrigationService.updateSeanceIrrigation(id, seanceIrrigationDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeanceIrrigation(@PathVariable Long id) {
        if (seanceIrrigationService.deleteSeanceIrrigation(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
