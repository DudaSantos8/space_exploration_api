package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;

public interface Spacecraft {
    SpacecraftResponseDto createSpacecraft(SpacecraftRegisterDto registerDto);
    SpacecraftResponseDto getSpacecraftStatus(int idSpacecraft);
}
