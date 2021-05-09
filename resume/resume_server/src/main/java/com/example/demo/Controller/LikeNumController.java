package com.example.demo.Controller;

import com.example.demo.service.LikeNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@CrossOrigin
public class LikeNumController {
    @Autowired(required=false)
    private LikeNumService LikeNumService;

    @RequestMapping("/client/addLikeNum")
    public int addLikeNum() {
        return LikeNumService.addLikeNum();
    }

    @RequestMapping("/client/getLikeNum")
    public int getLikeNum(){
        return LikeNumService.getLikeNum();
    }
}
