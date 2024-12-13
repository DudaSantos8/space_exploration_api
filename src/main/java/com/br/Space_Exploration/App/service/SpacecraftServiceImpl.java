package com.br.Space_Exploration.App.service;

import com.br.Space_Exploration.App.ports.output.TravelRepository;
import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.dtos.Travel;
import com.br.Space_Exploration.Domain.usercases.Spacecraft;
import com.br.Space_Exploration.App.ports.input.SpacecraftService;
import com.br.Space_Exploration.App.ports.output.SpacecraftRepository;
import com.br.Space_Exploration.infra.adapters.input.mapper.SpacecraftMapper;
import com.br.Space_Exploration.infra.adapters.input.mapper.TravelMapper;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.infra.adapters.output.entities.TravelEntity;
import org.springframework.stereotype.Service;

@Service
public class SpacecraftServiceImpl implements SpacecraftService {

    private final SpacecraftRepository repository;
    private final TravelRepository travelRepository;
    private final SpacecraftMapper mapper;
    private final TravelMapper travelMapper;
    private final Spacecraft spacecraftUsercase;

    public SpacecraftServiceImpl(SpacecraftRepository repository, TravelRepository travelRepository, SpacecraftMapper mapper, TravelMapper travelMapper, Spacecraft spacecraftUsercase) {
        this.repository = repository;
        this.travelRepository = travelRepository;
        this.mapper = mapper;
        this.travelMapper = travelMapper;
        this.spacecraftUsercase = spacecraftUsercase;
    }

    @Override
    public TravelEntity doTravel(String namePlanet, SpacecraftResponseDto spacecraft) {
        SpacecraftEntity entity = repository.getById(spacecraft.getId());
        Travel travel = spacecraftUsercase.doTravel(namePlanet, spacecraft);
        return travelRepository.save(travelMapper.toEntity(travel, entity));
    }

    @Override
    public SpacecraftResponseDto createSpacecraft(SpacecraftRegisterDto registerDto) {
        return mapper.toResponse(repository.save(mapper.toEntity(registerDto)));
    }

    @Override
    public SpacecraftResponseDto getSpacecraftStatus(int idSpacecraft) {
        return mapper.toResponse(repository.getById(idSpacecraft));
    }

    @Override
    public SpacecraftResponseDto updateSpacecraft(int idSpacecraft, SpacecraftRegisterDto registerDto) {
        SpacecraftEntity existingSpacecraft = repository.getById(idSpacecraft);

        existingSpacecraft.setName(registerDto.getName());
        existingSpacecraft.setFuel(registerDto.getFuel());
        existingSpacecraft.setOxygen(registerDto.getOxygen());
        existingSpacecraft.setEnergy(registerDto.getEnergy());

        SpacecraftEntity updatedSpacecraft = repository.update(existingSpacecraft);

        return mapper.toResponse(updatedSpacecraft);
    }
}
