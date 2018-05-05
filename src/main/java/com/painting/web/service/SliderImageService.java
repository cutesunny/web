package com.painting.web.service;

import com.painting.web.dao.SliderImageDao;
import com.painting.web.entity.SliderImage;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SliderImageService {


    private SliderImageDao sliderImageDao;

    @Autowired
    public SliderImageService(SliderImageDao sliderImageDao) {
        this.sliderImageDao = sliderImageDao;
    }


    public List<SliderImage> findAll() {
        return sliderImageDao.findAll();
    }


}
