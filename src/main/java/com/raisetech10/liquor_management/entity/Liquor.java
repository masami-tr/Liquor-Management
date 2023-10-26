package com.raisetech10.liquor_management.entity;

public class Liquor {
    private int id;
    private String liquorType;
    private String producingCountry;
    private String liquorName;
    private int alcoholContent;

    public Liquor(int id, String liquorType, String producingCountry, String liquorName, int alcoholContent) {
        this.id = id;
        this.liquorType = liquorType;
        this.producingCountry = producingCountry;
        this.liquorName = liquorName;
        this.alcoholContent = alcoholContent;
    }

    public int getId() {
        return id;
    }

    public String getLiquorType() {
        return liquorType;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public String getLiquorName() {
        return liquorName;
    }

    public int getAlcoholContent() {
        return alcoholContent;
    }
}
