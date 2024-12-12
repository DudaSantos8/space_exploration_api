package com.br.Space_Exploration.App.ports.output;

import com.br.Space_Exploration.Domain.dtos.Travel;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.infra.adapters.output.entities.TravelEntity;

public interface TravelRepository {
    TravelEntity getById(int id);
    TravelEntity save (TravelEntity travelEntity);
}
