package com.br.Space_Exploration.infra.adapters.input.mapper;

import com.br.Space_Exploration.Domain.dtos.PlanetDto;
import com.br.Space_Exploration.Domain.dtos.PlanetResponseDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;

public class PlanetMapper {
    public PlanetResponseDto toPlanetResponse(PlanetDto planetDto, SpacecraftResponseDto responseDto){
        PlanetResponseDto planetResponseDto = new PlanetResponseDto();

        planetResponseDto.setResponseDto(responseDto);
        planetResponseDto.setName(planetDto.getName());
        planetResponseDto.setDescription(planetDto.getDescription());
        planetResponseDto.setDistanceSun(planetDto.getDistanceSun());

        return planetResponseDto;
    }
}
