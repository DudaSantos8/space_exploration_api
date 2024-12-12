package com.br.Space_Exploration.Domain;

import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;

import java.util.ArrayList;
import java.util.List;

public class EvaluateSpacecraftForTravel {

    private static final double CONSUMPTION_FUEL_KM = 0.5;
    private static final double CONSUMPTION_OXYGEN_KM = 0.1;
    private static final double CONSUMPTION_ENERGY_KM = 0.2;

    private double calculateFuelConsumption(double distanceKm) {
        return CONSUMPTION_FUEL_KM * distanceKm;
    }

    private double calculateOxygenConsumption(double distanceKm) {
        return CONSUMPTION_OXYGEN_KM * distanceKm;
    }

    private double calculateEnergyConsumption(double distanceKm) {
        return CONSUMPTION_ENERGY_KM * distanceKm;
    }

    private boolean assessWhetherYouCanTravel(SpacecraftResponseDto spacecraftResponseDto, double distanceKm) {
        double fuelConsumption = calculateFuelConsumption(distanceKm);
        double oxygenConsumption = calculateOxygenConsumption(distanceKm);
        double energyConsumption = calculateEnergyConsumption(distanceKm);

        return spacecraftResponseDto.getFuel() >= fuelConsumption
                && spacecraftResponseDto.getOxygen() >= oxygenConsumption
                && spacecraftResponseDto.getEnergy() >= energyConsumption;
    }

    public List<Double> tryTakeTrip(SpacecraftResponseDto spacecraftResponseDto, double distanceKm) {
        if (assessWhetherYouCanTravel(spacecraftResponseDto, distanceKm)) {
            List<Double> valuesOfShip = new ArrayList<>();
            double fuelConsumption = calculateFuelConsumption(distanceKm);
            double oxygenConsumption = calculateOxygenConsumption(distanceKm);
            double energyConsumption = calculateEnergyConsumption(distanceKm);

            spacecraftResponseDto.setFuel(spacecraftResponseDto.getFuel() - fuelConsumption);
            spacecraftResponseDto.setOxygen(spacecraftResponseDto.getOxygen() - oxygenConsumption);
            spacecraftResponseDto.setEnergy(spacecraftResponseDto.  getEnergy() - energyConsumption);
            valuesOfShip.add(fuelConsumption);
            valuesOfShip.add(oxygenConsumption);
            valuesOfShip.add(energyConsumption);
            return valuesOfShip;
        }
        return List.of();
    }
}
