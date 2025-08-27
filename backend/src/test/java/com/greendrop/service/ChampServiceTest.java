package com.greendrop.service;

import com.greendrop.dto.ChampDTO;
import com.greendrop.model.*;
import com.greendrop.repository.AgriculteurRepository;
import com.greendrop.repository.ChampRepository;
import com.greendrop.repository.CultureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // No need for AutoConfigureTestDatabase with @SpringBootTest + H2 dependency
class ChampServiceTest {

    @Autowired
    private ChampService champService;

    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private AgriculteurRepository agriculteurRepository; // Added repository for setup

    @Autowired
    private CultureRepository cultureRepository; // Added repository for setup

    private Agriculteur savedAgriculteur;
    private Culture savedCulture;

    /**
     * This method runs before each test. It sets up the necessary
     * parent entities (Agriculteur and Culture) in the database,
     * so our Champ tests have valid IDs to reference.
     */
    @BeforeEach
    void setUp() {
        // Create and save a dummy Agriculteur for our tests to use
        Agriculteur agriculteur = new Agriculteur();
        agriculteur.setNom("Test");
        agriculteur.setPrenom("Farmer");
        agriculteur.setEmail("farmer@test.com");
        agriculteur.setPassword("password");
        savedAgriculteur = agriculteurRepository.save(agriculteur);

        // Create and save a dummy Culture for our tests to use
        Culture culture = new Culture();
        culture.setNom("Test Crop");
        culture.setSaison("Spring");
        savedCulture = cultureRepository.save(culture);
    }

    @Test
    void testCreateChamp() {
        ChampDTO dto = new ChampDTO();
        dto.setLongueur(100.0f);
        dto.setLargeur(50.0f);
        dto.setSoilType(SoilType.sandy);
        dto.setChampStatus(ChampStatus.Green);
        // Use the IDs from the objects we created in the setUp() method
        dto.setAgriculteurId(savedAgriculteur.getId());
        dto.setCultureId(savedCulture.getId());

        ChampDTO saved = champService.createChamp(dto);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getLongueur()).isEqualTo(100.0f);
        assertThat(saved.getAgriculteurId()).isEqualTo(savedAgriculteur.getId());
    }

    @Test
    void testGetAllChamps() {
        ChampDTO dto = new ChampDTO();
        dto.setLongueur(120.0f);
        dto.setLargeur(60.0f);
        dto.setSoilType(SoilType.clay);
        dto.setChampStatus(ChampStatus.Red);
        dto.setAgriculteurId(savedAgriculteur.getId());
        dto.setCultureId(savedCulture.getId());
        champService.createChamp(dto);

        List<ChampDTO> list = champService.getAllChamps();

        assertThat(list).hasSize(1);
    }

    @Test
    void testGetChampById() {
        ChampDTO dto = new ChampDTO();
        dto.setLongueur(80.0f);
        dto.setLargeur(40.0f);
        dto.setSoilType(SoilType.loamy);
        dto.setChampStatus(ChampStatus.Green);
        dto.setAgriculteurId(savedAgriculteur.getId());
        dto.setCultureId(savedCulture.getId());
        ChampDTO saved = champService.createChamp(dto);

        Optional<ChampDTO> found = champService.getChampById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getId()).isEqualTo(saved.getId());
    }

    @Test
    void testUpdateChamp() {
        ChampDTO originalDto = new ChampDTO();
        originalDto.setLongueur(150.0f);
        originalDto.setLargeur(70.0f);
        originalDto.setSoilType(SoilType.peaty);
        originalDto.setChampStatus(ChampStatus.Red);
        originalDto.setAgriculteurId(savedAgriculteur.getId());
        originalDto.setCultureId(savedCulture.getId());
        ChampDTO saved = champService.createChamp(originalDto);

        ChampDTO updateDto = new ChampDTO();
        updateDto.setLongueur(160.0f); // New value
        updateDto.setLargeur(saved.getLargeur());
        updateDto.setSoilType(saved.getSoilType());
        updateDto.setChampStatus(saved.getChampStatus());
        updateDto.setAgriculteurId(saved.getAgriculteurId());
        updateDto.setCultureId(saved.getCultureId());

        Optional<ChampDTO> updated = champService.updateChamp(saved.getId(), updateDto);

        assertThat(updated).isPresent();
        assertThat(updated.get().getLongueur()).isEqualTo(160.0f);
    }

    @Test
    void testDeleteChamp() {
        ChampDTO dto = new ChampDTO();
        dto.setLongueur(90.0f);
        dto.setLargeur(45.0f);
        dto.setSoilType(SoilType.silty);
        dto.setChampStatus(ChampStatus.Green);
        dto.setAgriculteurId(savedAgriculteur.getId());
        dto.setCultureId(savedCulture.getId());
        ChampDTO saved = champService.createChamp(dto);

        boolean deleted = champService.deleteChamp(saved.getId());

        assertThat(deleted).isTrue();
        Optional<ChampDTO> found = champService.getChampById(saved.getId());
        assertThat(found).isNotPresent();
    }
}