package com.br.Space_Exploration.App.ports.output;

import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;

import java.util.Optional;

public interface SpacecraftRepository {
    Optional<SpacecraftEntity> getById(int id);
    SpacecraftEntity save (SpacecraftEntity spacecraftEntity);
    SpacecraftEntity update(SpacecraftEntity spacecraft);
    void delete(SpacecraftEntity spacecraftEntity);
    EventResponseDto generateRandomEvent();

}
