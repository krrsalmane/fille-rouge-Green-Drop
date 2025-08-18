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



    @PostMapping("/add")
    public ResponseEntity<SeanceIrrigationDTO> createSeanceIrrigation(@RequestBody SeanceIrrigationDTO seanceIrrigationDTO) {
        SeanceIrrigationDTO createdSeanceIrrigation = seanceIrrigationService.createSeanceIrrigation(seanceIrrigationDTO);
        return new ResponseEntity<>(createdSeanceIrrigation, HttpStatus.CREATED);
    }


}
