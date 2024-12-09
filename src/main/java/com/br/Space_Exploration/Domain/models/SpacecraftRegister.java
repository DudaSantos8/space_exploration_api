package com.br.Space_Exploration.Domain.models;

public class SpacecraftRegister {

    private String name;
    private int fuel;
    private int oxygen;
    private int energy;

    public SpacecraftRegister(String name, int fuel, int oxygen, int energy) {
        this.name = name;
        this.fuel = fuel;
        this.oxygen = oxygen;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
