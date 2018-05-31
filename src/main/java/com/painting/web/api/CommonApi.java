package com.painting.web.api;

import com.baidu.ueditor.ActionEnter;
import com.painting.web.entity.Calligraphy;
import com.painting.web.entity.Painting;
import com.painting.web.service.CalligraphyService;
import com.painting.web.service.PaintingService;
import com.painting.web.util.QiniuStorageUtil;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 公用API
 */
@RestController
public class CommonApi {


    @Autowired
    private QiniuStorageUtil uploadTool;
    @Autowired
    private CalligraphyService calligraphyService;
    @Autowired
    private PaintingService paintingService;


    /***
     * 获取Ueditor配置文件
     */
    @GetMapping(value = "/ueditor/config")
    public String getUeditorConf(HttpServletRequest request){
        String rootPath = CommonApi.class.getClassLoader().getResource("").getPath();
        rootPath+="static/admin/lib";
        rootPath = rootPath.substring(1);
        System.out.println(rootPath);
        String json = new ActionEnter(request, rootPath).exec();
        return json;
    }

    /**
     * Ueditor 上传图片
     * Ueditor上传图片和其它框架上传图片所上传的参数和返回信息格式有所不同,但是流程一样,故分开所写.调用同一个service函数
     */
    @PostMapping(value = "/ueditor/image")
    public Map<String, String> ueditorUploadImage(MultipartFile upFile){
        String fileOriginalName = upFile.getOriginalFilename();
        String fileName = System.currentTimeMillis()+fileOriginalName.substring(fileOriginalName.lastIndexOf("."), fileOriginalName.length());
        uploadTool.upload(upFile, fileName);
        Map<String, String> responseMap = new HashMap<>();
        //将返回数据转换为Ueditor框架所固定的格式
        responseMap.put("state", "SUCCESS");
        responseMap.put("url", uploadTool.getUrl()+fileName);
        responseMap.put("size", String.valueOf(upFile.getSize()));
        responseMap.put("original", uploadTool.getUrl()+fileName);
        responseMap.put("type", upFile.getContentType());
        return responseMap;
    }

    @GetMapping(value = "/search")
    public ResponseVO search(String key){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseVO.ERROR);
        Calligraphy calligraphy = calligraphyService.search(key);
        if(calligraphy != null){
            responseVO.setData("/calligraphy/"+calligraphy.getId());
        }else{
            Painting painting = paintingService.search(key);
            if(painting != null){
                responseVO.setData("/painting/"+painting.getId());
            }
        }
        return responseVO;
    }
}
