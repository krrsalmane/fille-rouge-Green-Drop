package com.greendrop.service;

import com.greendrop.dto.AgriculteurDTO;
import com.greendrop.model.Agriculteur;
import com.greendrop.repository.AgriculteurRepository;
import com.greendrop.mapper.AgriculteurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgriculteurService {

    @Autowired
    private AgriculteurRepository agriculteurRepository;

    @Autowired
    private AgriculteurMapper agriculteurMapper;

    public List<AgriculteurDTO> getAllAgriculteurs() {
        return agriculteurRepository.findAll().stream()
                .map(agriculteurMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<AgriculteurDTO> getAgriculteurById(Long id) {
        return agriculteurRepository.findById(id)
                .map(agriculteurMapper::toDto);
    }

    public AgriculteurDTO createAgriculteur(AgriculteurDTO agriculteurDTO) {
        Agriculteur agriculteur = agriculteurMapper.toEntity(agriculteurDTO);
        Agriculteur savedAgriculteur = agriculteurRepository.save(agriculteur);
        return agriculteurMapper.toDto(savedAgriculteur);
    }

    public Optional<AgriculteurDTO> updateAgriculteur(Long id, AgriculteurDTO agriculteurDTO) {
        return agriculteurRepository.findById(id)
                .map(existingAgriculteur -> {
                    agriculteurMapper.updateAgriculteurFromDto(agriculteurDTO, existingAgriculteur);
                    return agriculteurMapper.toDto(agriculteurRepository.save(existingAgriculteur));
                });
    }

    public boolean deleteAgriculteur(Long id) {
        if (agriculteurRepository.existsById(id)) {
            agriculteurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
