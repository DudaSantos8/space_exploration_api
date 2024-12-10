package com.br.Space_Exploration.Domain.models;

public class EventResponse {

    private String name;
    private String description;
    private String typeFail;
    private int effect;

    public EventResponse(String name, String description, String typeFail, int effect) {
        this.name = name;
        this.description = description;
        this.typeFail = typeFail;
        this.effect = effect;
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

    public String getTypeFail() {
        return typeFail;
    }

    public void setTypeFail(String typeFail) {
        this.typeFail = typeFail;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }
}
