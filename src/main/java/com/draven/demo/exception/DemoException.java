
/**
 * 2018-4-27      刘佳豪   1.0         1.0 Version  
 *
*/  

package com.draven.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**  
 * 全局异常处理类  
 * 2018-4-27      刘佳豪      1.0         1.0 Version  
 *
*/

@ControllerAdvice
@ResponseBody
public class DemoException {

    private static final Logger logger = LoggerFactory.getLogger(DemoException.class.getName());
    
    @ExceptionHandler(value=MyException.class)
    public Map<String,String> MyException(HttpServletRequest request,MyException myException)
    {  
        Map<String,String> map = new HashMap<String,String>();
        map.put("code", myException.getCode());
        map.put("msg", myException.getMsg());
        map.put("url", request.getRequestURL().toString());
        logger.info("code:"+map.get("code"));
        logger.warn("msg:"+map.get("msg"));
        logger.error("url:"+map.get("url"));
      return map;  
    } 
}
