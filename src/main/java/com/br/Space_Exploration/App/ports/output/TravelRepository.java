package com.br.Space_Exploration.App.ports.output;

import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.infra.adapters.output.entities.TravelEntity;

import java.util.List;
import java.util.Optional;

public interface TravelRepository {
    Optional<TravelEntity> findTopBySpacecraftOrderByIdDesc(SpacecraftEntity spacecraft);
    List<TravelEntity> getAllTravelsBySpacecraft(SpacecraftEntity spacecraft);
    TravelEntity save (TravelEntity travelEntity);
}
