package com.raisetech10.liquor_management;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LiquorMapper {

    @Select("Select * FROM  liquor")
    List<Liquor> findAll();
    /* @Select("Select * FROM liquor WHERE id = #{id]")
       optional<Lipuor> findById(int id); */

    //以下カンニングする　INseret



}
