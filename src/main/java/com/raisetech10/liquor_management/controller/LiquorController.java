package com.raisetech10.liquor_management.controller;


import com.raisetech10.liquor_management.entity.Liquor;
import com.raisetech10.liquor_management.form.LiquorCreateRequest;
import com.raisetech10.liquor_management.form.LiquorUpdateRequest;
import com.raisetech10.liquor_management.service.LiquorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class LiquorController {

    //field
    private final LiquorService liquorService;

    //constructor
    public LiquorController(LiquorService liquorService) {
        this.liquorService = liquorService;
    }

    //GETの実装
    //全件取得の実装
    @GetMapping("/liquors")
    public List<Liquor> liquors() {
        List<Liquor> liquors = liquorService.findAll();
        return liquors;
    }

    //ID検索で該当データ取得＋例外処理
    @GetMapping("/liquors/{id}")
    public Liquor findById(@PathVariable("id") int id) {
        return liquorService.findById(id);
    }

    //POST
    //お酒のデータを新規登録
    @PostMapping("/liquors")
    public ResponseEntity<LiquorResponse> createLiquor(@RequestBody LiquorCreateRequest liquorCreateRequest, UriComponentsBuilder uriComponentsBuilder) {
        Liquor liquor = liquorService.createLiquor(liquorCreateRequest.covertToLiquor());
        URI uri = uriComponentsBuilder
                .path("/liquors/{id}")
                .buildAndExpand(liquor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new LiquorResponse("★a new liquor is created★"));
    }

    //PATCH
    //お酒のデータを更新
    @PatchMapping("/liquors/{id}")
    public ResponseEntity<LiquorResponse> updateLiquor(@PathVariable("id") int id, @RequestBody LiquorUpdateRequest liquorUpdateRequest) {
        liquorService.updateLiquor(id, liquorUpdateRequest.getLiquorType(), liquorUpdateRequest.getProducingCountry(), liquorUpdateRequest.getLiquorName(), liquorUpdateRequest.getAlcoholContent());
        return ResponseEntity.ok(new LiquorResponse("★a liquor is updated★"));
    }

    //DELETE
    //お酒のデータを削除
    @DeleteMapping("/liquors/{id}") //idを指定して削除
    public ResponseEntity<LiquorResponse> deleteLiquor(@PathVariable("id") int id) {
        liquorService.deleteLiquor(id);
        return ResponseEntity.ok(new LiquorResponse("★a liquor is deleted★"));
    }


}






