package com.example.demo.dao;

import com.example.demo.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface messageDao {
    @Insert("Insert into message (name, content, time, url) Values (#{name}, #{content}, #{time}, #{url})")
    int insertMessage(@Param("name") String name,
                      @Param("content") String content,
                      @Param("time") String time,
                      @Param("url") String url
                      );

    @Select("SELECT * FROM message ORDER BY time DESC")
    List<Message> getMessage();
}
