package com.raisetech10.liquor_management.entity;

import java.util.Objects;

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

    //CREATE機能 DBテスト用コンストラクタ
    public Liquor(String liquorType, String producingCountry, String liquorName, int alcoholContent) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setLiquorType(String liquorType) {
        this.liquorType = liquorType;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public void setLiquorName(String liquorName) {
        this.liquorName = liquorName;
    }

    public void setAlcoholContent(int alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Liquor liquor = (Liquor) obj;

        // ここで各フィールドの比較を行う
        return id == liquor.id &&
                Objects.equals(liquorType, liquor.liquorType) &&
                Objects.equals(producingCountry, liquor.producingCountry) &&
                Objects.equals(liquorName, liquor.liquorName) &&
                Objects.equals(alcoholContent, liquor.alcoholContent);
    }

}
