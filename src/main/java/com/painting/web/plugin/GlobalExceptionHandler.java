package com.painting.web.plugin;

import com.painting.web.entity.IException;
import com.painting.web.vo.ResponseVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by wangxiaodong on 2018/5/16.
 */
@RestControllerAdvice(annotations = {RestController.class})
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseVO exceptionHandler(Exception e){
        e.printStackTrace();
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseVO.ERROR);
        responseVO.setErrMsg("未知错误");
        return responseVO;
    }

    @ExceptionHandler(value = IException.class)
    public ResponseVO iExceptionHandler(IException e){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseVO.SUCCESS);
        responseVO.setErrMsg(e.getMessage());
        return responseVO;
    }

}
