package com.painting.web.api;

import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import com.painting.web.service.UserLogService;
import com.painting.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/user-log")
public class UserLogApi {
    @Autowired
    private UserLogService userLogService;

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        userLogService.delete(id);
    }

}
