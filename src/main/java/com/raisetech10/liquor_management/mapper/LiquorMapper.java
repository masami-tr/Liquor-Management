package com.raisetech10.liquor_management.mapper;

import com.raisetech10.liquor_management.entity.Liquor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LiquorMapper {
    //GET
    @Select("Select * FROM liquor")
     List<Liquor> findAll();

    //GET Exception
    @Select("Select * FROM liquor WHERE id = #{id}")
    Optional<Liquor> findById(int id);

    //POST
    @Insert("INSERT INTO liquor (id, liquorType, producingCountry, liquorName, alcoholContent) VALUES (#{id}, #{liquorType}, #{producingCountry}, #{liquorName}, #{alcoholContent})")
    void insert(Liquor liquor);

    //PATCH
    @Update("UPDATE liquor SET liquorType = #{liquorType}, producingCountry = #{producingCountry}, liquorName = #{liquorName}, alcoholContent = #{alcoholContent} WHERE id = #{id}")
    void update(Liquor liquor);




}
