package com.raisetech10.liquor_management.controller;


import com.raisetech10.liquor_management.entity.Liquor;
import com.raisetech10.liquor_management.form.LiquorCreateRequest;
import com.raisetech10.liquor_management.service.LiquorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class LiquorController {

    //field
    private LiquorService liquorService;

   //constructor
    public LiquorController(LiquorService liquorService) {
        this.liquorService = liquorService;
    }

    //GETの実装
    //全件取得の実装
    @GetMapping("/liquor")
    public List<Liquor> liquors(){
        List<Liquor> liquors = liquorService.findAll();
        return liquors;
    }

    //POST
    //お酒のデータを新規登録
    @PostMapping("/liquor")
    public ResponseEntity<LiquorCreateResponse> createLiquor(@RequestBody LiquorCreateRequest liquorCreateRequest, UriComponentsBuilder uriComponentsBuilder) {
        Liquor liquor = liquorService.createLiquor(liquorCreateRequest.covertToLiquor());
        URI uri = uriComponentsBuilder.path("/liquor/{id}").buildAndExpand(liquor.getId()).toUri();
        return ResponseEntity.created(uri).body(new LiquorCreateResponse("★a new liquor is created★"));
    }





}
