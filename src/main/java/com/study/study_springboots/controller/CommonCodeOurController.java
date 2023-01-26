package com.study.study_springboots.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.study.study_springboots.service.CommonCodeOurService;

@Controller
@RequestMapping(value = "/commonCodeOur")
public class CommonCodeOurController {

    @Autowired
    CommonCodeOurService commonCodeOurService;

    @RequestMapping(value = { "/list", "/", "" }, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = commonCodeOurService.getList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/edit/{uniqueId}" }, method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeOurService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/edit");
        return modelAndView;
    }

    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    public ModelAndView update(@RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {
        Object resultMap = commonCodeOurService.updateAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/delete/{uniqueId}" }, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeOurService.deleteAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/deleteMulti" }, method = RequestMethod.POST)
    public ModelAndView deleteMulti(HttpServletRequest httpServletRequest, @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {

        // modelAndView.addObject("resultMap", resultMap);
        String[] deleteMultis = httpServletRequest.getParameterMap().get("COMMON_CODE_ID");
        params.put("deleteMultis", deleteMultis);
        Object resultMap = commonCodeOurService.deleteMulti(params);

        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/form" }, method = RequestMethod.GET)
    public ModelAndView form(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {

        modelAndView.setViewName("commonCode_our/edit");
        return modelAndView;
    }

    @RequestMapping(value = { "/formMulti" }, method = RequestMethod.GET)
    public ModelAndView formMulti(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {

        modelAndView.setViewName("commonCode_our/editMulti");
        return modelAndView;
    }

    @RequestMapping(value = { "/insert" }, method = RequestMethod.POST)
    public ModelAndView insert(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) throws IOException {
        String registerSeq = multipartHttpServletRequest.getParameter("REGISTER_SEQ");

        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file_first");
        String fileName = multipartFile.getOriginalFilename();

        String relativePath = "src\\main\\resources\\static\\files\\";
        // file 저장
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(relativePath + fileName));
        bufferedWriter.write(new String(multipartFile.getBytes()));

        commonCodeOurService.insertOne(params);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/insertMulti" }, method = RequestMethod.POST)
    public ModelAndView insertMulti(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) throws IOException {
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        String relativePath = "C:\\Develops\\study_springboots\\src\\main\\resources\\static\\files\\";
        // 파일 이름 뽑아내기
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();

            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            String originalFilename = multipartFile.getOriginalFilename();
            String storePath = relativePath + originalFilename;
            // 경로 설정
            multipartFile.transferTo(new File(storePath));
        }

        Object resultMap = commonCodeOurService.insertWithFilesAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_our/list");
        return modelAndView;
    }
}
