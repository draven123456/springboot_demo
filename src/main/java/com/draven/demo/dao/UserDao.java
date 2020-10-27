package com.draven.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.draven.demo.model.User;

@Mapper
public interface UserDao {
    String getName(User user);
    
    @Select("select name from user where id = #{user.id}# ")
    String getName2(@Param("user") User user);
}
