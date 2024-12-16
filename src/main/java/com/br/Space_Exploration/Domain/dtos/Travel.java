package com.br.Space_Exploration.Domain.dtos;


import java.time.LocalDate;

public class Travel {

    private SpacecraftResponseDto spacecraft;
    private String destination;
    private String event;
    private LocalDate date;
    private Double duration;
    private double fuelConsumed;
    private double oxygenConsumed;
    private double energyConsumed;

    public Travel() {
    }

    public SpacecraftResponseDto getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(SpacecraftResponseDto spacecraft) {
        this.spacecraft = spacecraft;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public double getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(double fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
    }

    public double getOxygenConsumed() {
        return oxygenConsumed;
    }

    public void setOxygenConsumed(double oxygenConsumed) {
        this.oxygenConsumed = oxygenConsumed;
    }

    public double getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(double energyConsumed) {
        this.energyConsumed = energyConsumed;
    }
}
