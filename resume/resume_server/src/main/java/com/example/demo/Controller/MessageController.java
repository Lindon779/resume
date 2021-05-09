package com.example.demo.Controller;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.tools.responseState;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@CrossOrigin
public class MessageController {
    @Autowired(required=false)
    private MessageService messageService;

    @PostMapping("/client/addMessage")
    public ResponseEntity<Map<String, Object>> addMessage(@RequestBody Message message) throws JSONException {
        if (message.getName() == null || message.getContent() == null || message.getUrl() == null){
            Map<String,Object> map = responseState.fail(402, "非法输入！");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.BAD_REQUEST);
        }
        else{
            int res = messageService.insertMessage(message.getName(), message.getContent(), message.getUrl());
            if (res == 1){
                Map<String,Object> map = responseState.success(null);
                return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
            }
            else{
                Map<String,Object> map = responseState.fail(403, "未知错误");
                return new ResponseEntity<Map<String,Object>>(map, HttpStatus.BAD_REQUEST);
            }
        }
    }

    @RequestMapping(value = "/client/getMessage")
    public ResponseEntity<Map<String,Object>> getMessage() throws JSONException {
        List<Message> messages = messageService.getMessage();
        if(messages.size() < 1){
            Map<String,Object> map = responseState.fail(401,"数据为空！");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }
        else{
            Map<String,Object> map = responseState.success(messages);
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ResponseEntity<Map<String,Object>> getUser() throws IOException {
//        List<Message> messages = messageService.getMessage();
//        Map<String,Object> map = responseState.success(messages);
//        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
//    }
}
