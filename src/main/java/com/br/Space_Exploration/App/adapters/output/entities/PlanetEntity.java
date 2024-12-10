package com.br.Space_Exploration.App.adapters.output.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "planets")
public class PlanetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double distanceSun;

    public PlanetEntity() {
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
