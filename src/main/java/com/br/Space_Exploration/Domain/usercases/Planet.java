package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.PlanetResponseDto;

public interface Planet {
    PlanetResponseDto doTravel(int idPlanet, int idSpacecraft);

    PlanetResponseDto leaveThePlanet(int idSpacecraft);
}
