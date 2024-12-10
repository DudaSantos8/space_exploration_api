package com.br.Space_Exploration.App.adapters.output.repositories;

import com.br.Space_Exploration.App.adapters.output.entities.PlanetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CrudPlanetRepository extends JpaRepository<PlanetEntity, Integer> {
    Optional<PlanetEntity> findByName(String name);
}
