package com.example.demo.service;

import com.example.demo.dao.likeNumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeNumService {
    @Autowired
    private likeNumDao likeNumDao;

    public int addLikeNum(){
        likeNumDao.addLikeNum();
        return likeNumDao.selectNum();
    }

    public int getLikeNum(){
        return likeNumDao.selectNum();
    }
}
