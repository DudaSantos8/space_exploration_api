package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
import com.br.Space_Exploration.Domain.dtos.PlanetResponseDto;

public interface Spacecraft {
    PlanetResponseDto doTravel(int idPlanet, int idSpacecraft);
    PlanetResponseDto leaveThePlanet(int idSpacecraft);
    EventResponseDto getEvent(int idSpacecraft);
}
