package com.br.Space_Exploration.ports.output;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.models.Spacecraft;

import java.util.Optional;

public interface SpacecraftRepository {
    SpacecraftResponseDto getByName(String name);
    SpacecraftResponseDto save (SpacecraftRegisterDto registerDto);
    void delete (int id);
}
