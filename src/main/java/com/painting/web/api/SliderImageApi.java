package com.painting.web.api;

import com.painting.web.entity.SliderImage;
import com.painting.web.service.SliderImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangxiaodong on 2018/5/14.
 */
@RestController
@RequestMapping(value = "/api/slider-image")
public class SliderImageApi {

    @Autowired
    private SliderImageService sliderImageService;

    @GetMapping(value = "/list")
    public List<SliderImage> findAll(){
        return sliderImageService.findAll();
    }
}
