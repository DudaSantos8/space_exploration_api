package com.br.Space_Exploration.infra.adapters.input.mapper;

import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.dtos.Travel;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.infra.adapters.output.entities.TravelEntity;

public class TravelMapper {
    public TravelEntity toEntity(Travel travel, SpacecraftEntity spacecraft){
        TravelEntity entity = new TravelEntity();

        entity.setSpacecraft(spacecraft);
        entity.setDestination(travel.getDestination().toUpperCase());
        entity.setDate(travel.getDate());
        entity.setDurationInDays(travel.getDuration());
        entity.setFuelConsumedInLiters(travel.getFuelConsumed());
        entity.setEnergyConsumedInKilowattHours(travel.getEnergyConsumed());
        entity.setOxygenConsumedInCubicMeters(travel.getOxygenConsumed());

        return entity;
    }

    public Travel toTravel(TravelEntity travelEntity, SpacecraftResponseDto spacecraftResponseDto){
        Travel travel = new Travel();

        travel.setSpacecraft(spacecraftResponseDto);
        travel.setDestination(travelEntity.getDestination());
        travel.setDate(travelEntity.getDate());
        travel.setDuration(travelEntity.getDurationInDays());
        travel.setFuelConsumed(travelEntity.getFuelConsumedInLiters());
        travel.setEnergyConsumed(travelEntity.getEnergyConsumedInKilowattHours());
        travel.setOxygenConsumed(travelEntity.getOxygenConsumedInCubicMeters());

        return travel;
    }
}
