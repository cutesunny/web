package com.painting.web.api;

import com.painting.web.entity.Calligraphy;
import com.painting.web.service.CalligraphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书法
 */
@RestController
@RequestMapping(value = "/api/calligraphy")
public class CalligraphyApi {

    @Autowired
    private CalligraphyService calligraphyService;


    @GetMapping(value = "/list")
    public Page<Calligraphy> getList(Integer pageNum, Integer pageSize, Integer type){
        return calligraphyService.findAll(pageNum, pageSize, type);
    }
}
