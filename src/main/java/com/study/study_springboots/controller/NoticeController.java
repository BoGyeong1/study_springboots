package com.study.study_springboots.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.study_springboots.beans.BoardBean;
import com.study.study_springboots.service.DataInfors;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView) {
        DataInfors dataInfors = new DataInfors();
        ArrayList<BoardBean> boardList = dataInfors.getDataListWithMemberBean2();
        modelAndView.addObject("boardList", boardList);

        modelAndView.setViewName("notice/list");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam HashMap<String, String> params, ModelAndView modelAndView) {
        params.put("title", params.get("title"));
        params.put("userName", params.get("userName"));
        params.put("content", params.get("content"));
        params.put("date", params.get("date"));
        modelAndView.addObject("params", params);
        // insert biz
        modelAndView.setViewName("notice/view");
        return modelAndView; // -->Dispatcher Servlet
    }

    @RequestMapping(value = "/edit/{title}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String title, ModelAndView modelAndView) {
        DataInfors dataInfors = new DataInfors();
        HashMap dataList = dataInfors.getDataByTitle(title);
        modelAndView.addObject("dataList", dataList);
        modelAndView.setViewName("notice/edit");
        return modelAndView;
    }

}
