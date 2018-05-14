package com.painting.web.controller;

import com.painting.web.entity.Calligraphy;
import com.painting.web.service.CalligraphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 书法
 */
@Controller
@RequestMapping(value = "/calligraphy")
public class CalligraphyController {


    @Autowired
    private CalligraphyService calligraphyService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("xingshu", calligraphyService.findAll(1, 4, Calligraphy.XING_SHU).getContent());
        model.addAttribute("caoshu", calligraphyService.findAll(1, 4, Calligraphy.CAO_SHU).getContent());
        model.addAttribute("kaishu", calligraphyService.findAll(1, 4, Calligraphy.KAI_SHU).getContent());
        return "/calligraphy";
    }

    @GetMapping(value = "/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("item", calligraphyService.getById(id));
        return "calligraphy_detail";
    }

    @GetMapping(value = "/list")
    public String list(Integer type, Integer pageNum, Integer pageSize, Model model){
        //model.addAttribute("page",calligraphyService.findAll(pageNum, pageSize, type));
        return "/calligraphy_list";
    }
}
