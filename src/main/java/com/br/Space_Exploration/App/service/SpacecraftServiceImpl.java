package com.br.Space_Exploration.App.service;

import com.br.Space_Exploration.App.ports.output.TravelRepository;
import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;

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
        Optional<TravelEntity> travelEntityOptional = travelRepository.findTopBySpacecraftOrderByIdDesc(mapper.toEntityFromResponse(spacecraft));
        if (travelEntityOptional.isPresent()) {
            TravelEntity travelEntity = travelEntityOptional.get();
            if (travelEntity.getDestination().equals(namePlanet)) {
                throw new RuntimeException("You are already on this planet");
            }

            Travel travel = spacecraftUsercase.doTravel(travelMapper.toTravel(travelEntity, spacecraft), namePlanet, spacecraft);
            SpacecraftResponseDto responseDto = updateSpacecraft(travel.getSpacecraft().getId(), mapper.toRegister(travel.getSpacecraft()));
            return travelRepository.save(travelMapper.toEntity(travel, mapper.toEntityFromResponse(responseDto)));
        }

        Travel firstTravel = spacecraftUsercase.doTravel(null, namePlanet, spacecraft);
        SpacecraftResponseDto responseDto = updateSpacecraft(firstTravel.getSpacecraft().getId(), mapper.toRegister(firstTravel.getSpacecraft()));
        return travelRepository.save(travelMapper.toEntity(firstTravel, mapper.toEntityFromResponse(responseDto)));
    }

    @Override
    public SpacecraftResponseDto createSpacecraft(SpacecraftRegisterDto registerDto) {
        return mapper.toResponseFromEntity(repository.save(mapper.toEntity(registerDto)));
    }

    @Override
    public SpacecraftResponseDto getSpacecraftStatus(int idSpacecraft) {
        Optional<SpacecraftEntity> responseDtoOptional = repository.getById(idSpacecraft);
        if(responseDtoOptional.isEmpty()){
            throw new RuntimeException("This ship don't exist");
        }
        return mapper.toResponseFromEntity(responseDtoOptional.get());
    }

    @Override
    public SpacecraftResponseDto updateSpacecraft(int idSpacecraft, SpacecraftRegisterDto registerDto) {
        Optional<SpacecraftEntity> existingSpacecraft = repository.getById(idSpacecraft);
        SpacecraftEntity spacecraftEntity = existingSpacecraft.get();
        spacecraftEntity.setName(registerDto.getName());
        spacecraftEntity.setFuel(registerDto.getFuel());
        spacecraftEntity.setOxygen(registerDto.getOxygen());
        spacecraftEntity.setEnergy(registerDto.getEnergy());

        SpacecraftEntity updatedSpacecraft = repository.update(spacecraftEntity);

        return mapper.toResponseFromEntity(updatedSpacecraft);
    }

    @Override
    public EventResponseDto generateRandomEvent() {
        Random random = new Random();
        EventResponseDto[] events = EventResponseDto.values();
        return events[random.nextInt(events.length)];
    }

    private void applyEventEffect(SpacecraftEntity spacecraft, EventResponseDto event) {
        Map<String, BiConsumer<SpacecraftEntity, Integer>> effectActions = new HashMap<>();

        effectActions.put("fuel", (s, effect) -> s.setFuel(s.getFuel() + effect));
        effectActions.put("oxygen", (s, effect) -> s.setOxygen(s.getOxygen() + effect));
        effectActions.put("energy", (s, effect) -> s.setEnergy(s.getEnergy() + effect));

        BiConsumer<SpacecraftEntity, Integer> effectAction = effectActions.get(event.getTypeFail());

        if (effectAction != null) {
            effectAction.accept(spacecraft, event.getEffect());
        }
    }
}
