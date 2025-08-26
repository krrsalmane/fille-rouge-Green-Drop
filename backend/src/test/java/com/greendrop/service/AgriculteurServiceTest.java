package com.greendrop.service;


import com.greendrop.dto.AgriculteurDTO;
import com.greendrop.model.Agriculteur;
import com.greendrop.repository.AgriculteurRepository;
import com.greendrop.mapper.AgriculteurMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // use H2 instead of MySQL
@Transactional // rollback after each test
class AgriculteurServiceTest {

    @Autowired
    private AgriculteurService agriculteurService;

    @Autowired
    private AgriculteurRepository agriculteurRepository;

    @Autowired
    private AgriculteurMapper agriculteurMapper;

    @Test
    @Rollback(false) // to see saved data in logs
    void testCreateAgriculteur() {
        AgriculteurDTO dto = new AgriculteurDTO();
        dto.setNom("Ali");
        dto.setPrenom("Karim");

        AgriculteurDTO saved = agriculteurService.createAgriculteur(dto);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getNom()).isEqualTo("Ali");
    }

    @Test
    void testGetAllAgriculteurs() {
        AgriculteurDTO dto = new AgriculteurDTO();
        dto.setNom("Mohamed");
        dto.setPrenom("Laaouane");
        agriculteurService.createAgriculteur(dto);

        List<AgriculteurDTO> list = agriculteurService.getAllAgriculteurs();

        assertThat(list).isNotEmpty();
    }

    @Test
    void testGetAgriculteurById() {
        AgriculteurDTO dto = new AgriculteurDTO();
        dto.setNom("Sara");
        dto.setPrenom("Youssef");
        AgriculteurDTO saved = agriculteurService.createAgriculteur(dto);

        Optional<AgriculteurDTO> found = agriculteurService.getAgriculteurById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getNom()).isEqualTo("Sara");
    }

    @Test
    void testUpdateAgriculteur() {
        AgriculteurDTO dto = new AgriculteurDTO();
        dto.setNom("Hassan");
        dto.setPrenom("Ali");
        AgriculteurDTO saved = agriculteurService.createAgriculteur(dto);

        dto.setNom("Updated Hassan");
        Optional<AgriculteurDTO> updated = agriculteurService.updateAgriculteur(saved.getId(), dto);

        assertThat(updated).isPresent();
        assertThat(updated.get().getNom()).isEqualTo("Updated Hassan");
    }

}
