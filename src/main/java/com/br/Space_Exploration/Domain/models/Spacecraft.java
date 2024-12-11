package com.br.Space_Exploration.Domain.models;

public class Spacecraft {
    private String name;
    private String description;
    private double distanceSun;

    public Spacecraft(String name, String description, double distanceSun) {
        this.name = name;
        this.description = description;
        this.distanceSun = distanceSun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDistanceSun() {
        return distanceSun;
    }

    public void setDistanceSun(double distanceSun) {
        this.distanceSun = distanceSun;
    }

}
