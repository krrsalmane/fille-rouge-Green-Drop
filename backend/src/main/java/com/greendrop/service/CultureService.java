package com.greendrop.service;

import com.greendrop.dto.CultureDTO;
import com.greendrop.model.Culture;
import com.greendrop.repository.CultureRepository;
import com.greendrop.mapper.CultureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CultureService {

    @Autowired
    private CultureRepository cultureRepository;

    @Autowired
    private CultureMapper cultureMapper;

    public List<CultureDTO> getAllCultures() {
        return cultureRepository.findAll().stream()
                .map(cultureMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CultureDTO> getCultureById(Long id) {
        return cultureRepository.findById(id)
                .map(cultureMapper::toDto);
    }

    public CultureDTO createCulture(CultureDTO cultureDTO) {
        Culture culture = cultureMapper.toEntity(cultureDTO);
        Culture savedCulture = cultureRepository.save(culture);
        return cultureMapper.toDto(savedCulture);
    }

    public Optional<CultureDTO> updateCulture(Long id, CultureDTO cultureDTO) {
        return cultureRepository.findById(id)
                .map(existingCulture -> {
                    cultureMapper.updateCultureFromDto(cultureDTO, existingCulture);
                    return cultureMapper.toDto(cultureRepository.save(existingCulture));
                });
    }

    public boolean deleteCulture(Long id) {
        if (cultureRepository.existsById(id)) {
            cultureRepository.deleteById(id);
            return true;
        }
        return false;
    }
}