package com.zl.springbootredis;

//import com.zl.springbootredis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testObj() throws Exception{
//        User user = new User();
//        user.setUsername("zm");
//        user.setPassword("xx");
//        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
//        operations.set("user",user);
//        User vo = (User) operations.get("user");
//        System.out.println(vo);
    }

}
