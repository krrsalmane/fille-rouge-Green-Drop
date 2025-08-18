package com.greendrop.service;

import com.greendrop.dto.ChampDTO;
import com.greendrop.model.Champ;
import com.greendrop.repository.ChampRepository;
import com.greendrop.mapper.ChampMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChampService {

    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private ChampMapper champMapper;

    public List<ChampDTO> getAllChamps() {
        return champRepository.findAll().stream()
                .map(champMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ChampDTO> getChampById(Long id) {
        return champRepository.findById(id)
                .map(champMapper::toDto);
    }

    public ChampDTO createChamp(ChampDTO champDTO) {
        Champ champ = champMapper.toEntity(champDTO);
        Champ savedChamp = champRepository.save(champ);
        return champMapper.toDto(savedChamp);
    }

    public Optional<ChampDTO> updateChamp(Long id, ChampDTO champDTO) {
        return champRepository.findById(id)
                .map(existingChamp -> {
                    champMapper.updateChampFromDto(champDTO, existingChamp);
                    return champMapper.toDto(champRepository.save(existingChamp));
                });
    }

    public boolean deleteChamp(Long id) {
        if (champRepository.existsById(id)) {
            champRepository.deleteById(id);
            return true;
        }
        return false;
    }
}