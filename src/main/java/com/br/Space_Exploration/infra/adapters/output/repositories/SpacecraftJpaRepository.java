package com.br.Space_Exploration.infra.adapters.output.repositories;

import com.br.Space_Exploration.infra.adapters.input.mapper.SpacecraftMapper;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.App.ports.output.SpacecraftRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SpacecraftJpaRepository implements SpacecraftRepository {

    private final JpaSpacecraftRepository repository;

    public SpacecraftJpaRepository(JpaSpacecraftRepository repository, SpacecraftMapper mapper) {
        this.repository = repository;
    }

    @Override
    public Optional<SpacecraftEntity> getById(int id) {
        Optional<SpacecraftEntity> entity = repository.findById(id);
        return entity;
    }

    @Override
    public SpacecraftEntity save(SpacecraftEntity spacecraftEntity) {
        return repository.save(spacecraftEntity);
    }

    @Override
    public SpacecraftEntity update(SpacecraftEntity spacecraft) {
        return repository.save(spacecraft);
    }
}

interface JpaSpacecraftRepository extends JpaRepository<SpacecraftEntity, Integer> {
}
