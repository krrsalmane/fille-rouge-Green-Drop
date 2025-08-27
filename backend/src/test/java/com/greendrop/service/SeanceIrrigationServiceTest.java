package com.greendrop.service;

import com.greendrop.dto.SeanceIrrigationDTO;
import com.greendrop.model.*;
import com.greendrop.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class SeanceIrrigationServiceTest {

    @Autowired
    private SeanceIrrigationService seanceIrrigationService;

    @Autowired
    private SeanceIrrigationRepository seanceIrrigationRepository;

    @Autowired
    private AgriculteurRepository agriculteurRepository;

    @Autowired
    private CultureRepository cultureRepository;

    @Autowired
    private ChampRepository champRepository;

    private Agriculteur savedAgriculteur;
    private Champ savedChamp;
    private Culture savedCulture;
    @BeforeEach
    void setUp() {
        // Clear repositories in the correct order to avoid constraint violations
        seanceIrrigationRepository.deleteAll();
        champRepository.deleteAll();
        cultureRepository.deleteAll();
        agriculteurRepository.deleteAll();

        // 1. Create a parent Agriculteur
        Agriculteur agriculteur = new Agriculteur();
        agriculteur.setNom("Test");
        agriculteur.setPrenom("Farmer");
        agriculteur.setEmail("farmer.irrigation@test.com");
        agriculteur.setPassword("password");
        savedAgriculteur = agriculteurRepository.save(agriculteur);

        // 2. Create a parent Culture for the Champ
        Culture culture = new Culture();
        culture.setNom("Corn");
        savedCulture = cultureRepository.save(culture);

        // 3. Create a parent Champ
        Champ champ = new Champ();
        champ.setAgriculteur(savedAgriculteur);
        champ.setCulture(savedCulture);
        champ.setChampStatus(ChampStatus.Green);
        champ.setLargeur(100f);
        champ.setLongueur(100f);
        champ.setSoilType(SoilType.loamy);
        savedChamp = champRepository.save(champ);
    }

    private SeanceIrrigationDTO createTestSeanceDTO() {
        SeanceIrrigationDTO dto = new SeanceIrrigationDTO();
        dto.setDate(LocalDate.now());
        dto.setHeure(LocalTime.of(8, 30));
        dto.setQuantiteEau(150.5f);
        dto.setAgriculteurId(savedAgriculteur.getId());
        dto.setChampId(savedChamp.getId());
        return dto;
    }

    @Test
    void testCreateSeanceIrrigation() {
        // Given
        SeanceIrrigationDTO dto = createTestSeanceDTO();

        // When
        SeanceIrrigationDTO savedDto = seanceIrrigationService.createSeanceIrrigation(dto);

        // Then
        assertThat(savedDto).isNotNull();
        assertThat(savedDto.getId()).isNotNull();
        assertThat(savedDto.getQuantiteEau()).isEqualTo(150.5f);
        assertThat(savedDto.getChampId()).isEqualTo(savedChamp.getId());
    }

    @Test
    void testGetAllSeanceIrrigations() {
        // Given
        seanceIrrigationService.createSeanceIrrigation(createTestSeanceDTO());

        // When
        List<SeanceIrrigationDTO> seances = seanceIrrigationService.getAllSeanceIrrigations();

        // Then
        assertThat(seances).isNotNull();
        assertThat(seances).hasSize(1);
    }

    @Test
    void testGetSeanceIrrigationById_WhenExists() {
        // Given
        SeanceIrrigationDTO savedDto = seanceIrrigationService.createSeanceIrrigation(createTestSeanceDTO());

        // When
        Optional<SeanceIrrigationDTO> foundDto = seanceIrrigationService.getSeanceIrrigationById(savedDto.getId());

        // Then
        assertThat(foundDto).isPresent();
        assertThat(foundDto.get().getId()).isEqualTo(savedDto.getId());
    }

    @Test
    void testGetSeanceIrrigationById_WhenNotExists() {
        // When
        Optional<SeanceIrrigationDTO> foundDto = seanceIrrigationService.getSeanceIrrigationById(999L);

        // Then
        assertThat(foundDto).isNotPresent();
    }

    @Test
    void testUpdateSeanceIrrigation_WhenExists() {
        // Given
        SeanceIrrigationDTO originalDto = seanceIrrigationService.createSeanceIrrigation(createTestSeanceDTO());
        SeanceIrrigationDTO updateDto = createTestSeanceDTO();
        updateDto.setQuantiteEau(200.0f); // New value

        // When
        Optional<SeanceIrrigationDTO> updatedDto = seanceIrrigationService.updateSeanceIrrigation(originalDto.getId(), updateDto);

        // Then
        assertThat(updatedDto).isPresent();
        assertThat(updatedDto.get().getId()).isEqualTo(originalDto.getId());
        assertThat(updatedDto.get().getQuantiteEau()).isEqualTo(200.0f);
    }

    @Test
    void testUpdateSeanceIrrigation_WhenNotExists() {
        // When
        Optional<SeanceIrrigationDTO> updatedDto = seanceIrrigationService.updateSeanceIrrigation(999L, createTestSeanceDTO());

        // Then
        assertThat(updatedDto).isNotPresent();
    }

    @Test
    void testDeleteSeanceIrrigation_WhenExists() {
        // Given
        SeanceIrrigationDTO savedDto = seanceIrrigationService.createSeanceIrrigation(createTestSeanceDTO());
        assertThat(seanceIrrigationRepository.existsById(savedDto.getId())).isTrue();

        // When
        boolean isDeleted = seanceIrrigationService.deleteSeanceIrrigation(savedDto.getId());

        // Then
        assertThat(isDeleted).isTrue();
        assertThat(seanceIrrigationRepository.existsById(savedDto.getId())).isFalse();
    }

    @Test
    void testDeleteSeanceIrrigation_WhenNotExists() {
        // When
        boolean isDeleted = seanceIrrigationService.deleteSeanceIrrigation(999L);

        // Then
        assertThat(isDeleted).isFalse();
    }
}