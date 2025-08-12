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

}
