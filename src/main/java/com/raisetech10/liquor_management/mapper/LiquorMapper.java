package com.raisetech10.liquor_management.mapper;

import com.raisetech10.liquor_management.entity.Liquor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LiquorMapper {
    //GET
    @Select("Select * FROM liquor")
     List<Liquor> findAll();



    //POST
    @Insert("INSERT INTO liquor_management(id, liquorType, producingCountry, liquorName, alcoholContent) VALUES (#{id}, #{liquorType}, #{producingCountry}, #{liquorName}, #{alcoholContent})")
    void insert(Liquor liquor);




}
