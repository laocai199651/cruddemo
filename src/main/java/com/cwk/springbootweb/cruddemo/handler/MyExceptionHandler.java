package com.cwk.springbootweb.cruddemo.handler;

import com.cwk.springbootweb.cruddemo.exception.CWKException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 没有自适应效果
     */
  /*  @ResponseBody
    @ExceptionHandler(CWKException.class)
    public Map<String, Object> handleException(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("mycode", "user.permission.deny");
        map.put("message", "user not support create");
        return map;
    }*/
    @ExceptionHandler(CWKException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        HashMap<String, Object> map = new HashMap<>();
        map.put("mycode", "user.permission.deny");
        map.put("message", "user not support create");
        request.setAttribute("myext", map);
        return "forward:/error";
    }

}
