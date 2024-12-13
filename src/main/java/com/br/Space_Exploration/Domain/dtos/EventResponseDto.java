package com.br.Space_Exploration.Domain.dtos;

public enum EventResponseDto {

    EVENT1("The spaceship finds a refueling station and gets extra fuel.", "Refueling successful! Fuel refilled.",
            "fuel",30),
    EVENT2("The engine failure consumes extra fuel.", "Engine failure! Extra fuel consumed.",
            "fuel",-10),
    EVENT3(" There's a leak in the life support system, and oxygen is lost.", "Oxygen leak detected! Oxygen reduced.",
            "oxygen", -15),
    EVENT4("The spaceship discovers a new oxygen source on a planet or station.", "Oxygen source discovered! Oxygen increased.",
            "oxygen", 20),
    EVENT5("Reduces the spaceship's energy due to solar interference.", "Solar storm! Energy reduced.",
            "energy", -20),
    EVENT6("The spaceship repairs its energy system and restores some energy.", "Repair completed! Energy restored.",
            "energy", 25),
    EVENT7("The spaceship successfully explores a new planet and recovers resources.", "Successful exploration! Energy recovered.",
            "energy", 10),
    EVENT8("A failure in the communication system consumes more energy.", "Communication failure! Extra energy consumed.",
            "energy", -10),
    EVENT9("The cooling system failed, causing increased oxygen consumption.","Excessive heating! Oxygen consumed.",
            "oxygen", -20),
    EVENT10("A crew member sabotaged the energy system, reducing energy.", "Internal sabotage! Energy compromised.",
            "energy", -25),
    EVENT11("A planet's gravity alters the spaceship's course, consuming more fuel and oxygen.", "Gravitational avalanche! Extra fuel and oxygen consumed.",
            "fuel", -20),
    EVENT12("The spaceship makes emergency repairs and restores some resources.", "Emergency repairs! Fuel and oxygen restored.",
            "oxygen", 5);



    private String name;
    private String description;
    private String typeFail;
    private int effect;

    EventResponseDto(String name, String description,String typeFail, int effect) {
        this.name = name;
        this.description = description;
        this.typeFail = typeFail;
        this.effect = effect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeFail(String typeFail) {
        this.typeFail = typeFail;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeFail() {
        return typeFail;
    }

    public int getEffect() {
        return effect;
    }
}
