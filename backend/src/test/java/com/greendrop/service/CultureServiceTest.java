package com.greendrop.service;

import com.greendrop.dto.CultureDTO;
import com.greendrop.model.ChampStatus;
import com.greendrop.repository.CultureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // Ensures each test runs in a transaction that is rolled back
class CultureServiceTest {

    @Autowired
    private CultureService cultureService;

    @Autowired
    private CultureRepository cultureRepository;

    @BeforeEach
    void cleanup() {
        // Clean the repository before each test to ensure isolation
        cultureRepository.deleteAll();
    }

    @Test
    void testCreateCulture() {
        // Given
        CultureDTO cultureDTO = new CultureDTO();
        cultureDTO.setNom("Tomato");
        cultureDTO.setSaison("Summer");
        cultureDTO.setBesoinsEnEau(50.5f);

        // When
        CultureDTO savedCulture = cultureService.createCulture(cultureDTO);

        // Then
        assertThat(savedCulture).isNotNull();
        assertThat(savedCulture.getId()).isNotNull();
        assertThat(savedCulture.getNom()).isEqualTo("Tomato");
    }

    @Test
    void testGetAllCultures() {
        // Given
        CultureDTO tomatoDTO = new CultureDTO();
        tomatoDTO.setNom("Tomato");
        cultureService.createCulture(tomatoDTO);

        CultureDTO potatoDTO = new CultureDTO();
        potatoDTO.setNom("Potato");
        cultureService.createCulture(potatoDTO);

        // When
        List<CultureDTO> cultures = cultureService.getAllCultures();

        // Then
        assertThat(cultures).isNotNull();
        assertThat(cultures).hasSize(2);
        assertThat(cultures.stream().map(CultureDTO::getNom)).containsExactlyInAnyOrder("Tomato", "Potato");
    }

    @Test
    void testGetCultureById_WhenExists() {
        // Given
        CultureDTO cultureDTO = new CultureDTO();
        cultureDTO.setNom("Carrot");
        CultureDTO savedCulture = cultureService.createCulture(cultureDTO);

        // When
        Optional<CultureDTO> foundCulture = cultureService.getCultureById(savedCulture.getId());

        // Then
        assertThat(foundCulture).isPresent();
        assertThat(foundCulture.get().getId()).isEqualTo(savedCulture.getId());
        assertThat(foundCulture.get().getNom()).isEqualTo("Carrot");
    }

    @Test
    void testGetCultureById_WhenNotExists() {
        // When
        Optional<CultureDTO> foundCulture = cultureService.getCultureById(999L); // Non-existent ID

        // Then
        assertThat(foundCulture).isNotPresent();
    }


    @Test
    void testUpdateCulture_WhenExists() {
        // Given
        CultureDTO originalCultureDTO = new CultureDTO();
        originalCultureDTO.setNom("Lettuce");
        originalCultureDTO.setSaison("Spring");
        CultureDTO savedCulture = cultureService.createCulture(originalCultureDTO);

        CultureDTO updatedInfoDTO = new CultureDTO();
        updatedInfoDTO.setNom("Iceberg Lettuce");
        updatedInfoDTO.setSaison("Autumn"); // Changed season
        updatedInfoDTO.setBesoinsEnEau(30.0f); // Added water needs

        // When
        Optional<CultureDTO> updatedCulture = cultureService.updateCulture(savedCulture.getId(), updatedInfoDTO);

        // Then
        assertThat(updatedCulture).isPresent();
        assertThat(updatedCulture.get().getId()).isEqualTo(savedCulture.getId());
        assertThat(updatedCulture.get().getNom()).isEqualTo("Iceberg Lettuce");
        assertThat(updatedCulture.get().getSaison()).isEqualTo("Autumn");
    }

    @Test
    void testUpdateCulture_WhenNotExists() {
        // Given
        CultureDTO updatedInfoDTO = new CultureDTO();
        updatedInfoDTO.setNom("Non-existent Crop");

        // When
        Optional<CultureDTO> updatedCulture = cultureService.updateCulture(999L, updatedInfoDTO);

        // Then
        assertThat(updatedCulture).isNotPresent();
    }


    @Test
    void testDeleteCulture_WhenExists() {
        // Given
        CultureDTO cultureDTO = new CultureDTO();
        cultureDTO.setNom("Onion");
        CultureDTO savedCulture = cultureService.createCulture(cultureDTO);
        assertThat(cultureRepository.existsById(savedCulture.getId())).isTrue();

        // When
        boolean isDeleted = cultureService.deleteCulture(savedCulture.getId());

        // Then
        assertThat(isDeleted).isTrue();
        assertThat(cultureRepository.existsById(savedCulture.getId())).isFalse();
    }

    @Test
    void testDeleteCulture_WhenNotExists() {
        // When
        boolean isDeleted = cultureService.deleteCulture(999L);

        // Then
        assertThat(isDeleted).isFalse();
    }

    @Test
    void testGetCultureStatus() {
        // Given
        CultureDTO cultureDTO = new CultureDTO();
        cultureDTO.setNom("Zucchini");
        CultureDTO savedCulture = cultureService.createCulture(cultureDTO);

        // When
        Optional<ChampStatus> status = cultureService.getCultureStatus(savedCulture.getId());

        // Then
        // This test confirms the current placeholder behavior.
        // It should be updated if the business logic in the service changes.
        assertThat(status).isPresent();
        assertThat(status.get()).isEqualTo(ChampStatus.Green);
    }
}