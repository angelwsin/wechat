package com.test.redis;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTx {
    
    private static int count  =10;
    Jedis jedisX = new Jedis();
    
    @Before
    public void pre(){
        jedisX.setnx("countx", count+"");
        jedisX.setnx("version","1");
    }
    
    @SuppressWarnings("resource")
    public void tx(){
        //模拟乐观锁
        Jedis jedis = new Jedis();
        jedis.watch("version");
        Transaction tx =  jedis.multi();
        tx.incr("version");
        tx.decr("countx");
        List<Object> resp =  tx.exec();
        System.out.println("减少库存:"+resp);
        
    }
    
    @Test
    public void exe()throws Exception{
        final CountDownLatch latch = new CountDownLatch(40);
        for(int i=0;i<40;i++){
            new Thread(){
               public void run() {
                   tx();
                   latch.countDown();
               }; 
            }.start();
        }
        latch.await();
        System.out.println(jedisX.get("countx"));
    }

}
