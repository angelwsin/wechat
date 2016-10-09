package com.test.wechat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import com.wechat.DefaultHttpPost;
import com.wechat.HttpRequestBuilder;
import com.wechat.WeChatTemplate;

public class WeChatTemplateTest {
    
   // @Test
    public void testGet(){
        WeChatTemplate we = new WeChatTemplate();
        try {
            System.out.println(we.doForString(HttpRequestBuilder.createHttpGet("https://www.baidu.com/"))); 
          //  System.out.println( we.doGetForString("https://www.baidu.com/"));
           
        } catch (ClientProtocolException e) {
           // logger.error("", e);
        } catch (IOException e) {
           // logger.error("", e);
        }
        
    }
    //@Test
    public void testPost(){
        WeChatTemplate we = new WeChatTemplate();
        Map<String,String> params = new HashMap<String, String>();
        params.put("usr", "wb-Geniustest9");
        params.put("pwd", "943943");
        params.put("authCode", "5vhh");
       HttpPost post = HttpRequestBuilder.createHttpPost("http://bkpartner.stable.mayibank.net/doLogin.htm", params);
       
        try {
            System.out.println(we.doForString(post));
        } catch (ClientProtocolException e) {
           // logger.error("", e);
        } catch (IOException e) {
           // logger.error("", e);
        } 
    }
    @Test
    public void testDefaultPost(){
        WeChatTemplate we = new WeChatTemplate();
        DefaultHttpPost post = new DefaultHttpPost("http://bkpartner.stable.mayibank.net/doLogin.htm");
        post.addparameter("usr", "wb-Geniustest9").addparameter("pwd", "943943")
        .addparameter("authCode", "5vhh").build();
        try {
            we.doForString(post);
        } catch (ClientProtocolException e) {
            //logger.error("", e);
        } catch (IOException e) {
            //logger.error("", e);
            e.printStackTrace();
        }
    }
    
}
