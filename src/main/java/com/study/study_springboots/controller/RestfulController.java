package com.study.study_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RestfulController {
    @RequestMapping(value = "/api/v1/helloworld", method = RequestMethod.GET)
    public String helloworld() {
        return "hello world !";
    }

    // params - title : "learn ajax!", description:"we learn with ajax!"
    @RequestMapping(value = "/api/v1/requestParams", method = RequestMethod.GET)
    public Map requestParams(@RequestParam Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.putAll(params);
        result.put("id", "bogyeongjin");
        return result;
    }

}
