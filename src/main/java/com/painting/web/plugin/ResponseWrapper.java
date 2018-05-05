package com.painting.web.plugin;

import com.painting.web.vo.ResponseVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@RestControllerAdvice//(annotations = { RestController.class })
public class ResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(@Nullable Object data,
                                  @Nullable MethodParameter methodParameter,
                                  @Nullable MediaType mediaType,
                                  @Nullable Class<? extends HttpMessageConverter<?>> aClass,
                                  @Nullable ServerHttpRequest serverHttpRequest,
                                  @Nullable ServerHttpResponse serverHttpResponse) {
        //null表示该controller没有返回值
        if (null == data) {
             return new ResponseVO().setCode(ResponseVO.SUCCESS);
        }
        return new ResponseVO().setData(data);
    }

    @Override
    public boolean supports(@Nullable MethodParameter methodParameter, @Nullable Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }
}
