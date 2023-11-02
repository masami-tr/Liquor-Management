package com.raisetech10.liquor_management.service;

import com.raisetech10.liquor_management.Exception.ResourceNotFoundException;
import com.raisetech10.liquor_management.entity.Liquor;
import com.raisetech10.liquor_management.mapper.LiquorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiquorServiceImpl implements LiquorService {

    //field
    private LiquorMapper liquorMapper;

    //constructor
    public LiquorServiceImpl(LiquorMapper liquorMapper) {
        this.liquorMapper = liquorMapper;
    }

    //GET
    @Override
    public List<Liquor> findAll(){
        return liquorMapper.findAll();
    }

    //GET Excepion
    @Override
    public Liquor findById(int id){
        Optional<Liquor> liquor = this.liquorMapper.findById(id);
        return liquor.orElseThrow(() -> new ResourceNotFoundException("★Liquor not found★" + id));
    }

    //POST
    @Override
    public Liquor createLiquor(Liquor liquor) {
        liquorMapper.insert(liquor);
        return liquor;
    }

    //PATCH
    @Override
    public Liquor updateLiquor(Liquor liquor) {
        liquorMapper.update(liquor);
        return liquor;
    }

}
