package com.study.study_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board_our")
public class BoardOurController {
    @RequestMapping(value = "/form", method = RequestMethod.GET) // board_our/form
    public String form() {
        return "board_our/form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) // board_our/save
    public String save() {
        // insert biz
        return "board_our/list";
    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET) // board_our/
    public String list() {
        return "board_our/list";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET) // board_our/view
    public String view() {
        return "board_our/view";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST) // board_our/edit
    public String edit() {
        return "board_our/edit";
    }

}