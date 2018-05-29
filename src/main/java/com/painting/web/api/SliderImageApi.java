package com.painting.web.api;

import com.painting.web.entity.SliderImage;
import com.painting.web.service.SliderImageService;
import com.painting.web.util.QiniuStorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by wangxiaodong on 2018/5/14.
 */
@RestController
@RequestMapping(value = "/api/slider-image")
public class SliderImageApi {

    @Autowired
    private SliderImageService sliderImageService;
    @Autowired
    private QiniuStorageUtil uploadTool;


    @GetMapping(value = "/list")
    public List<SliderImage> findAll(){
        return sliderImageService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        sliderImageService.delete(id);
    }
    @PostMapping
    public void add(MultipartFile upfile){
        String fileOriginalName = upfile.getOriginalFilename();
        String fileName = System.currentTimeMillis()+fileOriginalName.substring(fileOriginalName.lastIndexOf("."), fileOriginalName.length());
        uploadTool.upload(upfile, fileName);
        SliderImage sliderImage=new SliderImage();
        sliderImage.setPath(uploadTool.getUrl()+fileName);
        sliderImageService.add(sliderImage);
    }
}
