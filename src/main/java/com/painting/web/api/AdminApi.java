package com.painting.web.api;

import com.painting.web.entity.IException;
import com.painting.web.service.AdminService;
import com.painting.web.util.QiniuStorageUtil;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminApi {

    @Autowired
    private AdminService adminService;
    @Autowired
    private QiniuStorageUtil uploadTool;

    @PostMapping(value = "/login")
    public void login(String username, String password, HttpServletRequest request) throws IException {
        adminService.login(username, password, request.getSession());
    }

    @RequestMapping("/upload_image")
    public ResponseVO uploadImage(MultipartFile upfile ){
        String fileOriginalName = upfile.getOriginalFilename();
        String fileName = System.currentTimeMillis()+fileOriginalName.substring(fileOriginalName.lastIndexOf("."), fileOriginalName.length());
        uploadTool.upload(upfile, fileName);
        return new ResponseVO().setData( uploadTool.getUrl()+fileName);
    }
}
