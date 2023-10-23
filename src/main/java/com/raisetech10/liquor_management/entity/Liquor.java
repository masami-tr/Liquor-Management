package com.raisetech10.liquor_management.entity;

public class Liquor {
    private int id;
    private String lipuor_type;
    private String producing_country;
    private String liquor_name;
    private int alcohol_content;

    public Liquor(int id, String lipuor_type, String producing_country, String liquor_name, int alcohol_content) {
        this.id = id;
        this.lipuor_type = lipuor_type;
        this.producing_country = producing_country;
        this.liquor_name = liquor_name;
        this.alcohol_content = alcohol_content;
    }

    public int getId() {
        return id;
    }

    public String getLipuor_type() {
        return lipuor_type;
    }

    public String getProducing_country() {
        return producing_country;
    }

    public String getLiquor_name() {
        return liquor_name;
    }

    public int getAlcohol_content() {
        return alcohol_content;
    }
}
