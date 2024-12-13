package com.br.Space_Exploration.Domain.usercases.impl;

import com.br.Space_Exploration.Domain.EvaluateSpacecraftForTravel;
import com.br.Space_Exploration.Domain.dtos.EventResponseDto;
import com.br.Space_Exploration.Domain.dtos.PlanetResponseDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.dtos.Travel;
import com.br.Space_Exploration.Domain.usercases.Spacecraft;

import java.time.LocalDate;
import java.util.List;

public class SpacecraftImpl implements Spacecraft {

    private static final double standardSpeed = 50000.0;

    @Override
    public Travel doTravel(String namePlanet, SpacecraftResponseDto spacecraft) {
        EvaluateSpacecraftForTravel tripReview = new EvaluateSpacecraftForTravel();
        PlanetResponseDto planetResponseDto = PlanetResponseDto.valueOf(namePlanet);
        List<Double> travel =  tripReview.tryTakeTrip(spacecraft, planetResponseDto.getDistanceSun());
        if(travel.isEmpty()){
            throw new RuntimeException("You can't do this travel");
        }
        Travel travelRegister = registerTrip(planetResponseDto, spacecraft, travel.get(0), travel.get(1), travel.get(2));
        return travelRegister;
    }

    private Travel registerTrip(PlanetResponseDto planetResponseDto, SpacecraftResponseDto spacecraft, double fuelConsumed,
                                double oxygenConsumed, double energyConsumed) {

        Travel travel = new Travel();

        travel.setSpacecraft(spacecraft);
        travel.setDate(LocalDate.now());
        travel.setDestination(planetResponseDto.getName());
        travel.setFuelConsumed(fuelConsumed);
        travel.setEnergyConsumed(energyConsumed);
        travel.setOxygenConsumed(oxygenConsumed);
        travel.setDuration(calculateTravelTime(planetResponseDto));

        return travel;
    }

    private double calculateTravelTime(PlanetResponseDto planetResponseDto){
        double distanceInKm = planetResponseDto.getDistanceSun() * 1_000_000; // Converter para km
        double timeHours = distanceInKm / standardSpeed;
        return timeHours / 24;
    }
}
