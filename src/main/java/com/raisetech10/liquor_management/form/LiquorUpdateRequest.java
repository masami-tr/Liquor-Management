package com.raisetech10.liquor_management.form;

import com.raisetech10.liquor_management.entity.Liquor;

public class LiquorUpdateRequest {
    private int id;
    private String liquorType;
    private String producingCountry;
    private String liquorName;
    private int alcoholContent;

    public LiquorUpdateRequest(int id, String liquorType, String producingCountry, String liquorName, int alcoholContent) {
        this.id = id;
        this.liquorType = liquorType;
        this.producingCountry = producingCountry;
        this.liquorName = liquorName;
        this.alcoholContent = alcoholContent;
    }

    public Liquor covertToLiquor(int id){
        Liquor liquor = new Liquor(this.id, this.liquorType, this.producingCountry,this.liquorName,this.alcoholContent);
        return liquor;
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
