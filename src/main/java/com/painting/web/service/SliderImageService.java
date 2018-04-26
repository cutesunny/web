package com.painting.web.service;

import com.painting.web.dao.GalleryDao;
import com.painting.web.dao.GuestBookDao;
import com.painting.web.dao.SliderImageDao;
import com.painting.web.entity.GuestBook;
import com.painting.web.entity.SliderImage;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SliderImageService {


    private SliderImageDao sliderImageDao;

    @Autowired
    public SliderImageService(SliderImageDao sliderImageDao) {
        this.sliderImageDao = sliderImageDao;
    }


    public ResponseVO<List<SliderImage>> findAll() {
        ResponseVO<List<SliderImage>> responseEntity = new ResponseVO<>();
        responseEntity.setCode(200);
        List<SliderImage> SliderImages = sliderImageDao.findAll();
        responseEntity.setData(SliderImages);
        return responseEntity;
    }


}
