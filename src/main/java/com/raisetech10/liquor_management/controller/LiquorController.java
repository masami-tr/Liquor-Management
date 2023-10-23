package com.raisetech10.liquor_management.controller;


import com.raisetech10.liquor_management.service.LiquorService;
import com.raisetech10.liquor_management.entity.Liquor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LiquorController {

    private final LiquorService liquorService;

    public LiquorController(LiquorService liquorService) {
        this.liquorService = liquorService;
    }

    @GetMapping("/liquor") //データベースへデータを取りに行く
    public List<Liquor> getLiquor() {
    List<Liquor> liquors = liquorService.getLiquor();
    return liquors;
    }


}
