package com.br.Space_Exploration.Domain.models;

public class SpacecraftResponse {

    private int id;
    private String name;
    private int fuel;
    private int oxygen;
    private int energy;

    public SpacecraftResponse(int id, String name, int fuel, int oxygen, int energy) {
        this.id = id;
        this.name = name;
        this.fuel = fuel;
        this.oxygen = oxygen;
        this.energy = energy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
