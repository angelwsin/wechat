package com.wechat;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
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
        HttpEntity entity= EntityBuilder.create().setParameters(parameters).build();
        super.setEntity(entity);
    }
    
}
