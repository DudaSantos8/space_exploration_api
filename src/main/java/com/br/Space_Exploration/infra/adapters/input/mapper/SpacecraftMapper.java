package com.br.Space_Exploration.infra.adapters.input.mapper;

import com.br.Space_Exploration.Domain.dtos.SpacecraftRegisterDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;

public class SpacecraftMapper {
    public SpacecraftResponseDto toResponseFromEntity(SpacecraftEntity entity){
        SpacecraftResponseDto responseDto = new SpacecraftResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setName(entity.getName());
        responseDto.setEnergy(entity.getEnergy());
        responseDto.setFuel(entity.getFuel());
        responseDto.setOxygen(entity.getOxygen());

        return responseDto;
    }

    public SpacecraftEntity toEntity(SpacecraftRegisterDto registerDto){
        SpacecraftEntity entity = new SpacecraftEntity();

        entity.setName(registerDto.getName());
        entity.setFuel(registerDto.getFuel());
        entity.setOxygen(registerDto.getOxygen());
        entity.setEnergy(registerDto.getEnergy());

        return entity;
    }

    public SpacecraftEntity toEntityFromResponse(SpacecraftResponseDto responseDto){
        SpacecraftEntity entity = new SpacecraftEntity();

        entity.setId(responseDto.getId());
        entity.setName(responseDto.getName());
        entity.setFuel(responseDto.getFuel());
        entity.setOxygen(responseDto.getOxygen());
        entity.setEnergy(responseDto.getEnergy());

        return entity;
    }

    public SpacecraftRegisterDto toRegister(SpacecraftResponseDto responseDto){
        SpacecraftRegisterDto registerDto = new SpacecraftRegisterDto();

        registerDto.setName(responseDto.getName());
        registerDto.setFuel(responseDto.getFuel());
        registerDto.setOxygen(responseDto.getOxygen());
        registerDto.setEnergy(responseDto.getEnergy());

        return registerDto;
    }

}
