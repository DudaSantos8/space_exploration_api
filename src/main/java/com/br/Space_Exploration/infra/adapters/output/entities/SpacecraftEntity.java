package com.br.Space_Exploration.infra.adapters.output.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "spacecraft")
@Data
public class SpacecraftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double distanceSun;

    public SpacecraftEntity() {
    }
}
