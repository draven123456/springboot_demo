package com.draven.demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.draven.demo.redis.RedisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisService redisService;

    @Before
    public void setUp() {

    }

    @Test
    public void get() {
        String liu = null;
        String jia = null;
        redisService.add("liu","刘" ,10L);
        liu = redisService.get("liu");
        redisService.add("jia", "jia22", 10L);
        jia = redisService.get("jia");
        System.out.println("liu:"+liu+"|"+"jia:"+jia);
        redisService.delete("jia");
      
        
    }
}