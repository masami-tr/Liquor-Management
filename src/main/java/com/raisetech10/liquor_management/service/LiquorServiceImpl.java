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
    private final LiquorMapper liquorMapper;

    //constructor
    public LiquorServiceImpl(LiquorMapper liquorMapper) {
        this.liquorMapper = liquorMapper;
    }

    //GET
    @Override
    public List<Liquor> findAll() {
        return liquorMapper.findAll();
    }

    @Override
    public Liquor findById(int id) {
        Optional<Liquor> liquor = this.liquorMapper.findById(id);
        return liquor.orElseThrow(() -> new ResourceNotFoundException("★Liquor not found★"));
    }

    //POST
    @Override
    public Liquor createLiquor(Liquor liquor) {
        liquorMapper.insert(liquor);
        return liquor;
    }

    //PATCH
    @Override
    public Liquor updateLiquor(int id, String liquorType, String producingCountry, String liquorName, Integer alcoholContent) {
        Liquor liquor = liquorMapper.findLiquorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("★Liquor not found★"));
        if (liquorType != null) {
            liquor.setLiquorType(liquorType);
        }
        if (producingCountry != null) {
            liquor.setProducingCountry(producingCountry);
        }
        if (liquorName != null) {
            liquor.setLiquorName(liquorName);
        }
        if (alcoholContent != 0) {
            liquor.setAlcoholContent(alcoholContent);
        }
        liquorMapper.update(liquor);
        return liquor;
    }

    //DELETE
    @Override
    public void deleteLiquor(int id) {
        liquorMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("*Liquor not found*"));
        liquorMapper.delete(id);
    }
}
