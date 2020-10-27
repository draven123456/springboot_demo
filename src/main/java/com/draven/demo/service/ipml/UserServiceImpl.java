package com.draven.demo.service.ipml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draven.demo.dao.UserDao;
import com.draven.demo.model.User;
import com.draven.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public String getName(User user) throws Exception{

//            int a = 1/0;

        
        return userDao.getName(user);
    }

    @Override
    public String getName2(User user) {
       
        return userDao.getName2(user);
    }
    

}
