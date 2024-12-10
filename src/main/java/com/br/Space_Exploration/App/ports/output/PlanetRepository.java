package com.br.Space_Exploration.App.ports.output;

import com.br.Space_Exploration.Domain.models.PlanetResponse;

import java.util.Optional;

public interface PlanetRepository {
    Optional<PlanetResponse> findByName(String name);
}
