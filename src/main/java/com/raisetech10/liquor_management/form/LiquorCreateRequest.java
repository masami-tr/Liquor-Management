package com.raisetech10.liquor_management.form;

import com.raisetech10.liquor_management.entity.Liquor;

public class LiquorCreateRequest {
    private int id;
    private String liquor_type;
    private String producting_contry;
    private String liquor_name;
    private int alcohol_content;

    public LiquorCreateRequest(int id, String liquor_type, String producting_contry, String liquor_name, int alcohol_content) {
        this.id = id;
        this.liquor_type = liquor_type;
        this.producting_contry = producting_contry;
        this.liquor_name = liquor_name;
        this.alcohol_content = alcohol_content;
    }

    public Liquor covertToLiquor(){
        Liquor liquor = new Liquor(this.id, this.liquor_type, this.producting_contry,this.liquor_name,this.alcohol_content);
        return liquor;
    }

    public int getId() {
        return id;
    }

    public String getLiquor_type() {
        return liquor_type;
    }

    public String getProducting_contry() {
        return producting_contry;
    }

    public String getLiquor_name() {
        return liquor_name;
    }

    public int getAlcohol_content() {
        return alcohol_content;
    }
}
