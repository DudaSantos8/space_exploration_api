package com.br.Space_Exploration.infra.adapters.input.mapper;

import com.br.Space_Exploration.Domain.dtos.Travel;
import com.br.Space_Exploration.infra.adapters.output.entities.SpacecraftEntity;
import com.br.Space_Exploration.infra.adapters.output.entities.TravelEntity;

public class TravelMapper {
    public TravelEntity toEntity(Travel travel, SpacecraftEntity spacecraft){
        TravelEntity entity = new TravelEntity();

        entity.setSpacecraft(spacecraft);
        entity.setDestination(travel.getDestination());
        entity.setDate(travel.getDate());
        entity.setDurationInDays(travel.getDuration());
        entity.setFuelConsumedInLiters(travel.getFuelConsumed());
        entity.setEnergyConsumedInKilowattHours(travel.getEnergyConsumed());
        entity.setOxygenConsumedInCubicMeters(travel.getOxygenConsumed());

        return entity;
    }
}
