package com.br.Space_Exploration.App.ports.input;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;

public interface SpacecraftService {
    SpacecraftResponseDto createSpacecraft(SpacecraftRegisterDto registerDto);
    SpacecraftResponseDto getSpacecraftStatus(int idSpacecraft);
    SpacecraftResponseDto updateSpacecraft(int idSpacecraft, SpacecraftRegisterDto registerDto);
}
