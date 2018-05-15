package com.painting.web.api;

import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import com.painting.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public void login(String username, String password, HttpServletRequest request) throws IException {
        userService.login(username, password, request.getSession());
    }
    @PostMapping(value = "/register")
    public void login(User user) throws IException {
        userService.register(user);
    }
}
