package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
import com.br.Space_Exploration.Domain.dtos.PlanetResponseDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.dtos.Travel;

public interface Spacecraft {
    Travel getTravelBySpacecraftId(SpacecraftResponseDto responseDto);
    Travel doTravel(String namePlanet, SpacecraftResponseDto spacecraft);
    PlanetResponseDto leaveThePlanet(int idSpacecraft);
    EventResponseDto getEvent(int idSpacecraft);
}
