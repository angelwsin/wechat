package com.wechat;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

public class DefaultHttpPost extends HttpPost {
    
    private List<NameValuePair> parameters = new ArrayList<NameValuePair>();
    
    public DefaultHttpPost() {
        super();
        this.setHeader("Content-Type", "text/html;charset=utf-8");
    }

    public DefaultHttpPost(final URI uri) {
        super();
        setURI(uri);
        this.setHeader("Content-Type", "text/html;charset=utf-8");
    }

    public DefaultHttpPost(final String uri) {
        super();
        setURI(URI.create(uri));
        this.setHeader("Content-Type", "text/html;charset=utf-8");
    }
    
    public DefaultHttpPost addHeaderValue(String name, String value){
        this.setHeader(name, value);
        return this;
     }
    
    public DefaultHttpPost addparameter(String name,String value){
        parameters.add(new BasicNameValuePair(name,value));
        return this;
    }
    public void build() {
        
       // HttpEntity entity= EntityBuilder.create().setParameters(parameters).build();
        try {
            super.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
        } catch (UnsupportedEncodingException e) {
           // logger.error("", e);
        }
    }
    
    public void buildStringContent(String paramter) {
        super.setEntity(new StringEntity(paramter, "utf-8"));
    }
    
}
