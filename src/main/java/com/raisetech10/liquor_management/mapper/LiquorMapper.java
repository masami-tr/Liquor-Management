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
    /* @Select("Select * FROM liquor WHERE id = #{id]")
       optional<Lipuor> findById(int id); */


    //POST
    @Select("SELECT name FROM movie_list WHERE name = #{name}")
   // Optional<String> findMovie(String name);

    @Insert("INSERT INTO liquor_management (id, liquor_type, producing_country, liquor_name, alcohol_content) VALUES (#{id}, #{liquor_type},#{producing_country},#{liquor_name},#{alcohol_content})")
    //@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Liquor liquor);




}
