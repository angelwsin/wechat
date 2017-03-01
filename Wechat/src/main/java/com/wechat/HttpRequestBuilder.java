package com.wechat;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;

public class HttpRequestBuilder {
    
    
       public static HttpGet  createHttpGet(String url,Map<String,String> headers,Map<String,String> params){
            HttpGet get = new HttpGet();
            if(headers==null){
                get.setHeader("Content-Type", "text/html;charset=utf-8");
                 }else{
                       for(String key:headers.keySet()){
                             get.setHeader(key, headers.get(key));
                       }
             }
                 StringBuffer buffer = new StringBuffer(url);
                 if(params!=null){
                      buffer.append("?");
                     for(String key:params.keySet()){
                          buffer.append(key).append("=").append(params.get(key)).append("&");
                   }
                    if(buffer.lastIndexOf("&")!=-1){
                         buffer.deleteCharAt(buffer.lastIndexOf("&"));
                    }
                 }
                 try {
                    get.setURI(new URI(buffer.toString()));
                } catch (URISyntaxException e) {
                  //  logger.error("", e);
                }
              return get;
       }
       
       
       public static HttpPost  createHttpPost(String url,Map<String,String> headers,Map<String,String> params){
           HttpPost post = new HttpPost(url);
           if(headers==null){
               post.setHeader("Content-Type", "text/html;charset=utf-8");
           }else{
                 for(String key:headers.keySet()){
                   post.setHeader(key, headers.get(key));
                 }
           }
        List<NameValuePair> nvps = new ArrayList <NameValuePair>();  
   
        Set<String> keySet = params.keySet();  
        for(String key : keySet) {  
            nvps.add(new BasicNameValuePair(key, params.get(key)));  
        }  
        HttpEntity entity= EntityBuilder.create().setParameters(nvps).build();
        post.setEntity(entity);
      return post;
       }
    
       public static HttpGet  createHttpGet(String url){
               return createHttpGet(url, null, null);
       }
       
       public static HttpPost  createHttpPost(String url,Map<String,String> params){
           return createHttpPost(url, null, params);
       }
       
       public static HttpPost createUpLoadHttpPost(String url,File file,Map<String,String> params){
           HttpPost post = new HttpPost(url);
           FileBody bin = new FileBody(file);  
         MultipartEntityBuilder builder  = MultipartEntityBuilder.create();
         if(params!=null){
             Set<String> keySet = params.keySet();  
             for(String key : keySet) {  
                builder.addTextBody(key, params.get(key));
             }    
         }
          builder.addPart("media", bin);
         HttpEntity entity =  builder.build();
         post.setEntity(entity);
         return post;
       }

}
