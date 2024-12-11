package com.br.Space_Exploration.Domain.usercases;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.models.SpacecraftResponse;

public interface Exploration {
    SpacecraftResponse createSpacecraft(SpacecraftRegisterDto registerDto);

    SpacecraftResponse getSpacecraftStatus(int idSpacecraft);
}
