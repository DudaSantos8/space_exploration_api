package com.br.Space_Exploration.adapters.output.repositories;

import com.br.Space_Exploration.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.ports.output.SpacecraftRepository;
import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public class SpacecraftJpaRepository implements SpacecraftRepository {

    private final JpaSpacecraftRepository repository;

    public SpacecraftJpaRepository(JpaSpacecraftRepository repository) {
        this.repository = repository;
    }

    @Override
    public SpacecraftResponseDto getByName(String name) {
        Optional<SpacecraftEntity> entity = repository.findByName(name);
        ObjectMapper objectMapper = new ObjectMapper();
        SpacecraftResponseDto spacecraft = objectMapper.convertValue(entity, SpacecraftResponseDto.class);
        return spacecraft;
    }

    @Override
    public SpacecraftResponseDto save(SpacecraftRegisterDto registerDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        SpacecraftEntity spacecraft = objectMapper.convertValue(registerDto, SpacecraftEntity.class);
        repository.save(spacecraft);
        return objectMapper.convertValue(spacecraft, SpacecraftResponseDto.class);
    }

    @Override
    public void delete(int id) {
        Optional<SpacecraftEntity> spacecraft = repository.findById(id);
        if(spacecraft.isEmpty()){
            throw new RuntimeException("this spacecraft don't exist");
        }
        repository.delete(spacecraft.get());
    }
}

@Repository
interface JpaSpacecraftRepository extends JpaRepository<SpacecraftEntity, Integer> {
    Optional<SpacecraftEntity> findByName(String name);
}