package com.br.Space_Exploration.Domain.dtos;

public enum PlanetResponseDto {
    MERCURY(1,"Mercury", "The closest planet to the Sun. It has extreme temperatures and no atmosphere.", 57.91),
    VENUS(2,"Venus", "A toxic and acidic atmosphere with surface temperatures higher than Mercury's.", 108.2),
    EARTH(3,"Earth", "Our home planet, with water and life. The only known planet to support life.", 149.6),
    MARS(4,"Mars", "The Red Planet. Known for its thin atmosphere and potential for future colonization.", 227.9),
    JUPITER(5,"Jupiter", "The largest planet in our solar system, a gas giant with massive storms.", 778.5),
    SATURN(6,"Saturn", "Famous for its beautiful rings. A gas giant with many moons.", 1433.5),
    URANUS(7,"Uranus", "An ice giant that rotates on its side, with a faint ring system.", 2872.5),
    NEPTUNE(8,"Neptune", "An ice giant with strong winds and deep blue color. Known for its cold atmosphere.", 4495.1);

    private int id;
    private String name;
    private String description;
    private double distanceSun;

    PlanetResponseDto(int id, String name, String description, double distanceSun) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.distanceSun = distanceSun;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDistanceSun(double distanceSun) {
        this.distanceSun = distanceSun;
    }
}
