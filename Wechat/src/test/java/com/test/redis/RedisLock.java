package com.test.redis;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisLock {
        
    @SuppressWarnings("resource")
    public void lock(){
        //分布式锁
        Jedis jedis = new Jedis();
        Long lock = jedis.setnx("lock", "lock");
        if(lock==1){
            System.out.println("获得锁"+Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
               // logger.error("", e);
            }finally{
               jedis.del("lock"); 
            }
        }else{
            System.out.println("没有得锁"+Thread.currentThread().getName());
        }
        
    }
    
    @Test
    public void exe()throws Exception{
        final CountDownLatch latch = new CountDownLatch(40);
        for(int i=0;i<40;i++){
            new Thread(){
               public void run() {
                   lock();
                   latch.countDown();
               }; 
            }.start();
        }
        latch.await();
    }
}
