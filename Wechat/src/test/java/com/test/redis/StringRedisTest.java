package com.test.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class StringRedisTest {
    
    
    @Test
    public  void incr() {
         Jedis jredis = new Jedis();
         long count = jredis.incr("counts");
         System.out.println(count);
         
    }

}
