package com.raisetech10.liquor_management.service;

import com.raisetech10.liquor_management.entity.Liquor;
import com.raisetech10.liquor_management.mapper.LiquorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiquorServiceImpl implements LiquorService {

    //フィールド定義
    private LiquorMapper liquorMapper;

    //コンストラクタ
    public LiquorServiceImpl(LiquorMapper liquorMapper) {
        this.liquorMapper = liquorMapper;
    }

    //GET
    @Override
    public List<Liquor> findAll(){
        return liquorMapper.findAll();
    }
    //POST
    @Override
    public Liquor createLiquor(Liquor liquor) {
        liquorMapper.insert(liquor);
        return liquor;
    }

}
