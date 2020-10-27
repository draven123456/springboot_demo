package com.draven.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draven.demo.exception.MyException;
import com.draven.demo.model.User;
import com.draven.demo.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/getName")
    public String getName(String id) throws Exception{
        User user = new User();
        if (id!=null) {
            user.setId(Integer.valueOf(id));
        }else {
            throw new MyException("400", "id为空");
        }
        
        String retString = userService.getName(user);
        return retString;
    }
    @RequestMapping("/getName2")
    public String getName2() {
        User user = new User();
        user.setId(2);
        String retString = userService.getName2(user);
        return retString;
    }
}
