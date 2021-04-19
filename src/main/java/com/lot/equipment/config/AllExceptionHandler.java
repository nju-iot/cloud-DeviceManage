package com.lot.equipment.config;

import javax.servlet.http.HttpServletRequest;

import com.lot.equipment.common.CommonException;
import com.lot.equipment.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handleException(Exception e, HttpServletRequest request) {
        Response response = new Response();
        // 判断异常类型是否为通用异常
        if (e instanceof CommonException) {
            CommonException userException = (CommonException) e;
            response.setCode(userException.getCode());
            response.setMessage(userException.getMessage());
        } else {
            // 系统异常
            log.error("url {}, msg {}", request.getRequestURL(), e.getMessage(), e);
            response.setCode("500");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
