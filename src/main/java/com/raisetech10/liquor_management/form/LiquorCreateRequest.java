package com.raisetech10.liquor_management.form;

import com.raisetech10.liquor_management.entity.Liquor;

public class LiquorCreateRequest {
    private int id;
    private String liquorType;
    private String productingContry;
    private String liquorName;
    private int alcoholContent;

    public LiquorCreateRequest(int id, String liquorType, String productingContry, String liquorName, int alcoholContent) {
        this.id = id;
        this.liquorType = liquorType;
        this.productingContry = productingContry;
        this.liquorName = liquorName;
        this.alcoholContent = alcoholContent;
    }

    public Liquor covertToLiquor(){
        Liquor liquor = new Liquor(this.id, this.liquorType, this.productingContry,this.liquorName,this.alcoholContent);
        return liquor;
    }

    public int getId() {
        return id;
    }

    public String getLiquorType() {
        return liquorType;
    }

    public String getProductingContry() {
        return productingContry;
    }

    public String getLiquorName() {
        return liquorName;
    }

    public int getAlcoholContent() {
        return alcoholContent;
    }
}
