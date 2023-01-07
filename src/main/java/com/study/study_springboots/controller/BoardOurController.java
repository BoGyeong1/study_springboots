package com.study.study_springboots.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.study_springboots.beans.BoardBean;
import com.study.study_springboots.service.DataInfors;

@Controller
@RequestMapping(value = "/board_our")
public class BoardOurController {
    @RequestMapping(value = "/form", method = RequestMethod.GET) // board_our/form
    public ModelAndView form(ModelAndView modelAndView) {

        modelAndView.setViewName("board_our/form");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) // board_our/save
    public ModelAndView save(ModelAndView modelAndView) {
        // insert biz

        modelAndView.setViewName("board_our/list");
        return modelAndView; // -->Dispatcher Servlet
    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET) // board_our/
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("firstString", "firstValue");
        DataInfors dataInfors = new DataInfors();
        ArrayList<BoardBean> boardList = dataInfors.getDataListWithMemberBean();
        modelAndView.addObject("boardList", boardList);
        modelAndView.setViewName("board_our/list");

        return modelAndView;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET) // board_our/view
    public ModelAndView view(ModelAndView modelAndView) {
        DataInfors dataInfors = new DataInfors();
        BoardBean boardBean = dataInfors.getDataWithMemberBean();
        modelAndView.addObject("boardBean", boardBean);

        modelAndView.setViewName("board_our/view");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST) // board_our/edit
    public ModelAndView edit(ModelAndView modelAndView) {
        modelAndView.setViewName("board_our/edit");
        return modelAndView;
    }

}