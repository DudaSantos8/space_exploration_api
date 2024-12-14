package com.br.Space_Exploration.Domain.usercases.impl;

import com.br.Space_Exploration.Domain.EvaluateSpacecraftForTravel;
import com.br.Space_Exploration.Domain.dtos.PlanetDto;
import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;
import com.br.Space_Exploration.Domain.dtos.Travel;
import com.br.Space_Exploration.Domain.usercases.Spacecraft;

import java.time.LocalDate;

public class SpacecraftImpl implements Spacecraft {

    private static final double standardSpeed = 50000.0;

    @Override
    public Travel doTravel(Travel lastTravel, String namePlanet, SpacecraftResponseDto spacecraft) {
        EvaluateSpacecraftForTravel tripReview = new EvaluateSpacecraftForTravel();

        PlanetDto planetDto = PlanetDto.valueOf(namePlanet);
        if(lastTravel != null){
            String lastDestination = lastTravel.getDestination();
            PlanetDto lastPlanet = PlanetDto.valueOf(lastDestination);
            SpacecraftResponseDto travelValidation =  tripReview.tryTakeTrip(lastTravel.getSpacecraft(), calculateTravelDistance(planetDto, lastPlanet));
            return registerTrip(planetDto, travelValidation, travelValidation.getFuel(), travelValidation.getOxygen(), travelValidation.getEnergy(), lastPlanet);
        }
        SpacecraftResponseDto travelValidation =  tripReview.tryTakeTrip(spacecraft, calculateTravelDistance(planetDto, PlanetDto.SUN));
        return registerTrip(planetDto, travelValidation, travelValidation.getFuel(), travelValidation.getOxygen(), travelValidation.getEnergy(), PlanetDto.SUN);
    }

    @Override
    public PlanetDto seeInformationPlanet(Travel lastTravel) {
        String namePlanet = lastTravel.getDestination();
        return PlanetDto.valueOf(namePlanet);
    }

    private Travel registerTrip(PlanetDto planetDto, SpacecraftResponseDto spacecraft, double fuelConsumed,
                                double oxygenConsumed, double energyConsumed, PlanetDto lastDestination) {

        Travel travel = new Travel();

        travel.setSpacecraft(spacecraft);
        travel.setDate(LocalDate.now());
        travel.setDestination(planetDto.getName());
        travel.setFuelConsumed(fuelConsumed);
        travel.setEnergyConsumed(energyConsumed);
        travel.setOxygenConsumed(oxygenConsumed);
        travel.setDuration(calculateTravelTime(planetDto, lastDestination));

        return travel;
    }

    private double calculateTravelTime(PlanetDto planetDto, PlanetDto lastDestination){
        double distanceInKm = planetDto.getDistanceSun() * 1_000_000;
        double timeHours = distanceInKm / standardSpeed;
        if(lastDestination != PlanetDto.SUN){
            double distanceBase = lastDestination.getDistanceSun() * 1_000_000;
            timeHours = (distanceInKm - distanceBase) / standardSpeed;
        }
        if (timeHours < 0.0){
            timeHours *= -1;
        }
        return timeHours / 24;
    }

    private double calculateTravelDistance(PlanetDto planetDto, PlanetDto lastDestination){
        double distance = planetDto.getDistanceSun();
        if(lastDestination != PlanetDto.SUN){
            double distanceBase = lastDestination.getDistanceSun();
            return Math.abs(distance - distanceBase);
        }
        return distance;
    }
}
