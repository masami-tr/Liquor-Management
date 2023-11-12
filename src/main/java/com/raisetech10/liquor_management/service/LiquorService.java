package com.raisetech10.liquor_management.service;

import com.raisetech10.liquor_management.entity.Liquor;

import java.util.List;

public interface LiquorService {

    List<Liquor> findAll();

    Liquor findById(int id);

    Liquor createLiquor(Liquor liquor);

    Liquor updateLiquor(int id, String liquorType, String producingCountry, String liquorName, Integer alcoholContent);

    Liquor deleteLiquor(int id);

}
