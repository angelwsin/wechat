package com.wechat;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class JsonToObjectResponseHandler implements ResponseHandler<Object>{

     private Class<?> clazz;
     public JsonToObjectResponseHandler(Class<?> clazz) {
          this.clazz = clazz;
    }
     
    public Object handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
        final StatusLine statusLine = response.getStatusLine();
        final HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusLine.getStatusCode(),
                    statusLine.getReasonPhrase());
        }
       String text =  entity == null ? null : EntityUtils.toString(entity,"utf-8");
       return JSONObject.parseObject(text, clazz);
     //  return JSON.parseObject(text, clazz, Feature.DisableCircularReferenceDetect) ;
    }
    
         
      

}
