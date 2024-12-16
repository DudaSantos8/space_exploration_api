package com.br.Space_Exploration.Domain;

import com.br.Space_Exploration.Domain.dtos.SpacecraftResponseDto;


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

    private double calculateResourceConsumption(double consumptionRate, double distanceKm) {
        return consumptionRate * distanceKm;
    }

    private boolean assessWhetherYouCanTravel(SpacecraftResponseDto spacecraftResponseDto, double distanceKm) {
        double fuelConsumption = calculateResourceConsumption(CONSUMPTION_FUEL_KM, distanceKm);
        double oxygenConsumption = calculateResourceConsumption(CONSUMPTION_OXYGEN_KM, distanceKm);
        double energyConsumption = calculateResourceConsumption(CONSUMPTION_ENERGY_KM, distanceKm);

        if (spacecraftResponseDto.getFuel() < fuelConsumption) {
            throw new IllegalArgumentException("Not enough fuel to complete the journey.");
        }
        if (spacecraftResponseDto.getOxygen() < oxygenConsumption) {
            throw new IllegalArgumentException("Not enough oxygen to complete the journey.");
        }
        if (spacecraftResponseDto.getEnergy() < energyConsumption) {
            throw new IllegalArgumentException("Not enough energy to complete the journey.");
        }

        return true;
    }

    public SpacecraftResponseDto tryTakeTrip(SpacecraftResponseDto spacecraftResponseDto, double distanceKm) {
        if (assessWhetherYouCanTravel(spacecraftResponseDto, distanceKm)) {
            double fuelConsumption = calculateFuelConsumption(distanceKm);
            double oxygenConsumption = calculateOxygenConsumption(distanceKm);
            double energyConsumption = calculateEnergyConsumption(distanceKm);

            spacecraftResponseDto.setFuel(spacecraftResponseDto.getFuel() - fuelConsumption);
            spacecraftResponseDto.setOxygen(spacecraftResponseDto.getOxygen() - oxygenConsumption);
            spacecraftResponseDto.setEnergy(spacecraftResponseDto.  getEnergy() - energyConsumption);
            return spacecraftResponseDto;
        }
        return spacecraftResponseDto;
    }
}
