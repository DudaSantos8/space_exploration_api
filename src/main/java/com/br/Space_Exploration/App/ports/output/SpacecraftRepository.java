package com.br.Space_Exploration.App.ports.output;

import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;

public interface SpacecraftRepository {
    SpacecraftEntity getById(int id);
    SpacecraftEntity save (SpacecraftEntity spacecraftEntity);
}
