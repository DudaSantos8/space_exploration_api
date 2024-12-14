package com.br.Space_Exploration.Domain.dtos;

public enum PlanetDto {
    SUN("Sun", "Sun star",0.0),
    MERCURY("Mercury", "The closest planet to the Sun. It has extreme temperatures and no atmosphere.", 57.91),
    VENUS("Venus", "A toxic and acidic atmosphere with surface temperatures higher than Mercury's.", 108.2),
    EARTH("Earth", "Our home planet, with water and life. The only known planet to support life.", 149.6),
    MARS("Mars", "The Red Planet. Known for its thin atmosphere and potential for future colonization.", 227.900000),
    JUPITER("Jupiter", "The largest planet in our solar system, a gas giant with massive storms.", 778.5),
    SATURN("Saturn", "Famous for its beautiful rings. A gas giant with many moons.", 1433.5),
    URANUS("Uranus", "An ice giant that rotates on its side, with a faint ring system.", 2872.5),
    NEPTUNE("Neptune", "An ice giant with strong winds and deep blue color. Known for its cold atmosphere.", 4495.1);

    private String name;
    private String description;
    private double distanceSun;

    PlanetDto(String name, String description, double distanceSun) {
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
