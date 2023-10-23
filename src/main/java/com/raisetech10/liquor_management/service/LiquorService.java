package com.raisetech10.liquor_management.service;

import com.raisetech10.liquor_management.entity.Liquor;
import com.raisetech10.liquor_management.mapper.LiquorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LiquorService {

    private final LiquorMapper liquorMapper;

    public LiquorService(LiquorMapper liquorMapper) {
        this.liquorMapper = liquorMapper; //DI
    }

    public List<Liquor> getLiquor(){ //findAllというメソッド　nameMapperに依頼して
        List<Liquor> liquors = liquorMapper.findAll();
        return liquors;

    }
}
