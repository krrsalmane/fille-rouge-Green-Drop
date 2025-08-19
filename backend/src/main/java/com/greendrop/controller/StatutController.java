package com.greendrop.controller;

import com.greendrop.model.ChampStatus;
import com.greendrop.service.ChampService;
import com.greendrop.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statuts")
public class StatutController {

    @Autowired
    private ChampService champService;

    @Autowired
    private CultureService cultureService;

    @GetMapping("/champ/{id}")
    public ResponseEntity<ChampStatus> getChampStatus(@PathVariable Long id) {
        // This method will call a service method to determine the champ's status
        return champService.getChampStatus(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
