package com.draven.demo.service;

import com.draven.demo.model.User;

public interface UserService {
    String getName(User user) throws Exception;
    String getName2(User user);
}
