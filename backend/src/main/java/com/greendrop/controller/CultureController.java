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



    @PostMapping("/add")
    public ResponseEntity<CultureDTO> createCulture(@RequestBody CultureDTO cultureDTO) {
        CultureDTO createdCulture = cultureService.createCulture(cultureDTO);
        return new ResponseEntity<>(createdCulture, HttpStatus.CREATED);
    }


}
