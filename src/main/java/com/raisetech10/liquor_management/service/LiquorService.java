package com.raisetech10.liquor_management.service;

import com.raisetech10.liquor_management.entity.Liquor;

import java.util.List;

public interface LiquorService {
    List<Liquor> findAll();

    Liquor createLiquor(Liquor liquor);

}
