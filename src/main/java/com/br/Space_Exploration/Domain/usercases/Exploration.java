package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.models.EventResponse;
import com.br.Space_Exploration.Domain.models.PlanetResponse;
import com.br.Space_Exploration.Domain.models.SpacecraftResponse;

public interface Exploration {
    SpacecraftResponse createSpacecraft(SpacecraftRegisterDto registerDto);

    EventResponse getEvent(int idSpacecraft);

    PlanetResponse doTravel(int idPlanet, int idSpacecraft);

    PlanetResponse leaveThePlanet(int idSpacecraft);

    SpacecraftResponse getSpacecraftStatus(int idSpacecraft);
}
