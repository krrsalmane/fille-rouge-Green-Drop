package com.greendrop.service;

import com.greendrop.dto.SeanceIrrigationDTO;
import com.greendrop.model.SeanceIrrigation;
import com.greendrop.repository.SeanceIrrigationRepository;
import com.greendrop.mapper.SeanceIrrigationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeanceIrrigationService {

    @Autowired
    private SeanceIrrigationRepository seanceIrrigationRepository;

    @Autowired
    private SeanceIrrigationMapper seanceIrrigationMapper;

    public List<SeanceIrrigationDTO> getAllSeanceIrrigations() {
        return seanceIrrigationRepository.findAll().stream()
                .map(seanceIrrigationMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<SeanceIrrigationDTO> getSeanceIrrigationById(Long id) {
        return seanceIrrigationRepository.findById(id)
                .map(seanceIrrigationMapper::toDto);
    }

    public SeanceIrrigationDTO createSeanceIrrigation(SeanceIrrigationDTO seanceIrrigationDTO) {
        SeanceIrrigation seanceIrrigation = seanceIrrigationMapper.toEntity(seanceIrrigationDTO);
        SeanceIrrigation savedSeanceIrrigation = seanceIrrigationRepository.save(seanceIrrigation);
        return seanceIrrigationMapper.toDto(savedSeanceIrrigation);
    }

    public Optional<SeanceIrrigationDTO> updateSeanceIrrigation(Long id, SeanceIrrigationDTO seanceIrrigationDTO) {
        return seanceIrrigationRepository.findById(id)
                .map(existingSeanceIrrigation -> {
                    seanceIrrigationMapper.updateSeanceIrrigationFromDto(seanceIrrigationDTO, existingSeanceIrrigation);
                    return seanceIrrigationMapper.toDto(seanceIrrigationRepository.save(existingSeanceIrrigation));
                });
    }

    public boolean deleteSeanceIrrigation(Long id) {
        if (seanceIrrigationRepository.existsById(id)) {
            seanceIrrigationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}