package com.br.Space_Exploration.infra.adapters.output.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "travel")
public class TravelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spacecraft_id")
    private SpacecraftEntity spacecraft;
    private String destination;
    private LocalDate date;
    private Double durationInDays;
    private double fuelConsumedInLiters;
    private double oxygenConsumedInCubicMeters;
    private double energyConsumedInKilowattHours;

    public TravelEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpacecraftEntity getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(SpacecraftEntity spacecraft) {
        this.spacecraft = spacecraft;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Double durationInDays) {
        this.durationInDays = durationInDays;
    }

    public double getFuelConsumedInLiters() {
        return fuelConsumedInLiters;
    }

    public void setFuelConsumedInLiters(double fuelConsumedInLiters) {
        this.fuelConsumedInLiters = fuelConsumedInLiters;
    }

    public double getOxygenConsumedInCubicMeters() {
        return oxygenConsumedInCubicMeters;
    }

    public void setOxygenConsumedInCubicMeters(double oxygenConsumedInCubicMeters) {
        this.oxygenConsumedInCubicMeters = oxygenConsumedInCubicMeters;
    }

    public double getEnergyConsumedInKilowattHours() {
        return energyConsumedInKilowattHours;
    }

    public void setEnergyConsumedInKilowattHours(double energyConsumedInKilowattHours) {
        this.energyConsumedInKilowattHours = energyConsumedInKilowattHours;
    }
}
