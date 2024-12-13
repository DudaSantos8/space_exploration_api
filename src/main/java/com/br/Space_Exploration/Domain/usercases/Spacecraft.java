package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.dtos.Travel;

public interface Spacecraft {
    Travel doTravel(String namePlanet, SpacecraftResponseDto spacecraft);
}
