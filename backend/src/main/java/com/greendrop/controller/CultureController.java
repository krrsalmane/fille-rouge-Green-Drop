package com.greendrop.controller;

import com.greendrop.dto.CultureDTO;
import com.greendrop.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultures")
public class CultureController {

    @Autowired
    private CultureService cultureService;

    @GetMapping
    public ResponseEntity<List<CultureDTO>> getAllCultures() {
        List<CultureDTO> cultures = cultureService.getAllCultures();
        return ResponseEntity.ok(cultures);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CultureDTO> getCultureById(@PathVariable Long id) {
        return cultureService.getCultureById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<CultureDTO> createCulture(@RequestBody CultureDTO cultureDTO) {
        CultureDTO createdCulture = cultureService.createCulture(cultureDTO);
        return new ResponseEntity<>(createdCulture, HttpStatus.CREATED);
    }


}
