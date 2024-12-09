package com.br.Space_Exploration.Domain.usercases.impl;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.models.EventResponse;
import com.br.Space_Exploration.Domain.models.PlanetResponse;
import com.br.Space_Exploration.Domain.models.SpacecraftResponse;
import com.br.Space_Exploration.Domain.usercases.Exploration;

public class ExplorationImpl implements Exploration {

    @Override
    public SpacecraftResponse createSpacecraft(SpacecraftRegisterDto registerDto) {
        return null;
    }

    @Override
    public EventResponse getEvent(int idSpacecraft) {
        return null;
    }

    @Override
    public PlanetResponse doTravel(int idPlanet, int idSpacecraft) {
        return null;
    }

    @Override
    public PlanetResponse leaveThePlanet(int idSpacecraft) {
        return null;
    }

    @Override
    public SpacecraftResponse getSpacecraftStatus(int idSpacecraft) {
        return null;
    }

}
