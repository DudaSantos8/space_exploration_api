package com.br.Space_Exploration.App.ports.input;

import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.infra.adapters.output.entities.TravelEntity;

public interface SpacecraftService {
    TravelEntity doTravel(String namePlanet, SpacecraftResponseDto responseDto);
    SpacecraftResponseDto createSpacecraft(SpacecraftRegisterDto registerDto);
    SpacecraftResponseDto getSpacecraftStatus(int idSpacecraft);
    SpacecraftResponseDto updateSpacecraft(int idSpacecraft, SpacecraftRegisterDto registerDto);
    EventResponseDto generateRandomEvent();
}
