package com.br.Space_Exploration.Domain.usercases.impl;

import com.br.Space_Exploration.Domain.EvaluateSpacecraftForTravel;
import com.br.Space_Exploration.Domain.dtos.PlanetResponseDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.dtos.Travel;
import com.br.Space_Exploration.Domain.usercases.Spacecraft;

import java.time.LocalDate;

public class SpacecraftImpl implements Spacecraft {

    private static final double standardSpeed = 50000.0;

    @Override
    public Travel doTravel(Travel lastTravel, String namePlanet, SpacecraftResponseDto spacecraft) {
        EvaluateSpacecraftForTravel tripReview = new EvaluateSpacecraftForTravel();

        PlanetResponseDto planetResponseDto = PlanetResponseDto.valueOf(namePlanet);
        if(lastTravel != null){
            String lastDestination = lastTravel.getDestination();
            PlanetResponseDto lastPlanet = PlanetResponseDto.valueOf(lastDestination);
            SpacecraftResponseDto travelValidation =  tripReview.tryTakeTrip(lastTravel.getSpacecraft(), calculateTravelDistance(planetResponseDto, lastPlanet));
            return registerTrip(planetResponseDto, travelValidation, travelValidation.getFuel(), travelValidation.getOxygen(), travelValidation.getEnergy(), lastPlanet);
        }
        SpacecraftResponseDto travelValidation =  tripReview.tryTakeTrip(spacecraft, calculateTravelDistance(planetResponseDto, PlanetResponseDto.SUN));
        return registerTrip(planetResponseDto, travelValidation, travelValidation.getFuel(), travelValidation.getOxygen(), travelValidation.getEnergy(), PlanetResponseDto.SUN);
    }

    private Travel registerTrip(PlanetResponseDto planetResponseDto, SpacecraftResponseDto spacecraft, double fuelConsumed,
                                double oxygenConsumed, double energyConsumed, PlanetResponseDto lastDestination) {

        Travel travel = new Travel();

        travel.setSpacecraft(spacecraft);
        travel.setDate(LocalDate.now());
        travel.setDestination(planetResponseDto.getName());
        travel.setFuelConsumed(fuelConsumed);
        travel.setEnergyConsumed(energyConsumed);
        travel.setOxygenConsumed(oxygenConsumed);
        travel.setDuration(calculateTravelTime(planetResponseDto, lastDestination));

        return travel;
    }

    private double calculateTravelTime(PlanetResponseDto planetResponseDto, PlanetResponseDto lastDestination){
        double distanceInKm = planetResponseDto.getDistanceSun() * 1_000_000;
        double timeHours = distanceInKm / standardSpeed;
        if(lastDestination != PlanetResponseDto.SUN){
            double distanceBase = lastDestination.getDistanceSun() * 1_000_000;
            timeHours = (distanceInKm - distanceBase) / standardSpeed;
        }
        if (timeHours < 0.0){
            timeHours *= -1;
        }
        return timeHours / 24;
    }

    private double calculateTravelDistance(PlanetResponseDto planetResponseDto, PlanetResponseDto lastDestination){
        double distance = planetResponseDto.getDistanceSun();
        if(lastDestination != PlanetResponseDto.SUN){
            double distanceBase = lastDestination.getDistanceSun();
            return Math.abs(distance - distanceBase);
        }
        return distance;
    }
}
