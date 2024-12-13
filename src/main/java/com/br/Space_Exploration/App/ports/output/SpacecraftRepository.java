package com.br.Space_Exploration.App.ports.output;

import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;

import java.util.Optional;

public interface SpacecraftRepository {
    Optional<SpacecraftEntity> getById(int id);
    SpacecraftEntity update(SpacecraftEntity spacecraft);
    SpacecraftEntity save (SpacecraftEntity spacecraftEntity);

}
