package com.br.Space_Exploration.App.ports.output;

import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;

public interface SpacecraftRepository {
    SpacecraftEntity getById(int id);
    SpacecraftEntity update(SpacecraftEntity spacecraft);
    SpacecraftEntity save (SpacecraftEntity spacecraftEntity);
    EventResponseDto generateRandomEvent();
}
