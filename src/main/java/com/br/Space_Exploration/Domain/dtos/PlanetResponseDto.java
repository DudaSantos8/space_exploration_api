package com.br.Space_Exploration.Domain.dtos;

public class PlanetResponseDto {

    private SpacecraftResponseDto responseDto;
    private String name;
    private String description;
    private double distanceSun;

    public PlanetResponseDto() {
    }

    public SpacecraftResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(SpacecraftResponseDto responseDto) {
        this.responseDto = responseDto;
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
