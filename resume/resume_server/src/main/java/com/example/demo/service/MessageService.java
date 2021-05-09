package com.example.demo.service;

import com.example.demo.dao.messageDao;
import com.example.demo.entity.Message;
import com.example.demo.tools.getCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private messageDao messageDao;

    public int insertMessage(String name, String content, String url) {
        getCurrentTime getCurrentTime = new getCurrentTime();
        String time = getCurrentTime.getTime();
        return messageDao.insertMessage(name, content, time, url);
    }

    public List<Message> getMessage(){
        return messageDao.getMessage();
    }
}
