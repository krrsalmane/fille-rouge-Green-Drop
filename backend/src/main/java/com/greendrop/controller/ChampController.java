package com.greendrop.controller;

import com.greendrop.dto.ChampDTO;
import com.greendrop.service.ChampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/champs")
public class ChampController {

    @Autowired
    private ChampService champService;



    @PostMapping("/add")
    public ResponseEntity<ChampDTO> createChamp(@RequestBody ChampDTO champDTO) {
        ChampDTO createdChamp = champService.createChamp(champDTO);
        return new ResponseEntity<>(createdChamp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChampDTO> updateChamp(@PathVariable Long id, @RequestBody ChampDTO champDTO) {
        return champService.updateChamp(id, champDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChamp(@PathVariable Long id) {
        if (champService.deleteChamp(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
