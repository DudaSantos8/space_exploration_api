package com.br.Space_Exploration.App.service;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.usercases.Spacecraft;
import com.br.Space_Exploration.ports.input.SpacecraftService;
import com.br.Space_Exploration.ports.output.SpacecraftRepository;

public class SpacecraftServiceImpl implements SpacecraftService {

    private final SpacecraftRepository repository;
    private final Spacecraft usercaseSpacecraft;

    public SpacecraftServiceImpl(SpacecraftRepository repository, Spacecraft usercaseSpacecraft) {
        this.repository = repository;
        this.usercaseSpacecraft = usercaseSpacecraft;
    }

    @Override
    public SpacecraftResponseDto createSpacecraft(SpacecraftRegisterDto registerDto) {
        return null;
    }

    @Override
    public SpacecraftResponseDto getSpacecraftStatus(int idSpacecraft) {
        return null;
    }
}
