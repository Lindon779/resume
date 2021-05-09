package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface likeNumDao {
    @Update("UPDATE like_num SET like_num=like_num+1 WHERE id='1';")
    int addLikeNum();

    @Select("SELECT like_num FROM like_num WHERE id='1';")
    int selectNum();
}
