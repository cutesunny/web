package com.painting.web.api;

import com.painting.web.entity.Painting;
import com.painting.web.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 书法
 */
@RestController
@RequestMapping(value = "/api/painting")
public class PaintingApi {

    @Autowired
    private PaintingService paintingService;


    @GetMapping(value = "/list")
    public Page<Painting> getList(Integer pageNum, Integer pageSize, Integer type){
        return paintingService.findAll(pageNum, pageSize, type);
    }

}
