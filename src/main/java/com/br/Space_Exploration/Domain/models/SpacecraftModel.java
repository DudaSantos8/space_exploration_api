package com.br.Space_Exploration.Domain.models;

public class SpacecraftModel {
    private String name;
    private double fuel;
    private double oxygen;
    private double energy;

    public SpacecraftModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}