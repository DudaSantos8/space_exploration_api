package com.br.Space_Exploration.infra.adapters.output.repositories;

import com.br.Space_Exploration.App.ports.output.SpacecraftRepository;
import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
import com.br.Space_Exploration.infra.adapters.input.mapper.SpacecraftMapper;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Random;

@Repository
public class SpacecraftJpaRepository implements SpacecraftRepository {

    private final JpaSpacecraftRepository repository;

    public SpacecraftJpaRepository(JpaSpacecraftRepository repository, SpacecraftMapper mapper) {
        this.repository = repository;
    }

    @Override
    public SpacecraftEntity getById(int id) {
        Optional<SpacecraftEntity> entity = repository.findById(id);
        return entity.get();
    }

    @Override
    public SpacecraftEntity save(SpacecraftEntity spacecraftEntity) {
        return repository.save(spacecraftEntity);
    }

    @Override
    public SpacecraftEntity update(SpacecraftEntity spacecraft) {
        return repository.save(spacecraft);
    }

    @Override
    public EventResponseDto generateRandomEvent() {
        Random random = new Random();
        EventResponseDto[] events = EventResponseDto.values();
        return events[random.nextInt(events.length)];
    }
}

interface JpaSpacecraftRepository extends JpaRepository<SpacecraftEntity, Integer> {
}
