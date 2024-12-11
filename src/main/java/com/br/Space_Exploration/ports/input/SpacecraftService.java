package com.br.Space_Exploration.ports.input;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;

public interface SpacecraftService {
    SpacecraftResponseDto createSpacecraft(SpacecraftRegisterDto registerDto);
    SpacecraftResponseDto getSpacecraftStatus(int idSpacecraft);
}
