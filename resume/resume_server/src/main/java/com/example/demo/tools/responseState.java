package com.example.demo.tools;

import java.util.HashMap;
import java.util.Map;

public class responseState {

    public static Map<String, Object> success(Object data){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("state", 200);
        map.put("msg", "success");
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> fail(int state, String msg){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("state", state);
        map.put("msg", msg);
        return map;
    }
}
