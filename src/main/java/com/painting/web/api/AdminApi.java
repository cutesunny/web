package com.painting.web.api;

import com.painting.web.dao.AdminDao;
import com.painting.web.entity.IException;
import com.painting.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminApi {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/login")
    public void login(String username, String password, HttpServletRequest request) throws IException {
        adminService.login(username, password, request.getSession());
    }
}
