package com.study.study_springboots.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/homejsp") // http://localhost:8080/homejsp
    public String homejsp() {
        int i = 0;

        return "WEB-INF/views/home.jsp";
    }

    @RequestMapping(value = "/homehtml") // http://localhost:8080/homehtml 해석하지 않음
    public String homehtml() {
        int i = 0;

        return "WEB-INF/views/home.html";
    }

    @RequestMapping(value = "/home") // http://localhost:8080/homehtml 해석하지 않음
    public void home() {
        int i = 0;

    }

    @RequestMapping(value = { "", "/", "/main" }) // http://localhost:8080/homehtml 해석하지 않음
    public String main() {
        int i = 0;
        return "WEB-INF/views/main.jsp";

    }
}
