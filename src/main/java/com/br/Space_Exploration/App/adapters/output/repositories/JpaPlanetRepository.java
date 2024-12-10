package com.br.Space_Exploration.App.adapters.output.repositories;

import com.br.Space_Exploration.App.ports.output.PlanetRepository;
import com.br.Space_Exploration.Domain.models.PlanetResponse;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaPlanetRepository implements PlanetRepository {

    private final CrudPlanetRepository crudRepository;

    public JpaPlanetRepository(CrudPlanetRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Optional<PlanetResponse> findByName(String name) {
        return crudRepository.findByName(name).map(planetEntity ->
                new PlanetResponse(planetEntity.getName(), planetEntity.getDescription(),
                        planetEntity.getDistanceSun()));
    }
}
