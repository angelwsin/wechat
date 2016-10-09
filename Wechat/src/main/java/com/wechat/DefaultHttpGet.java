package com.wechat;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;

public class DefaultHttpGet extends HttpGet {
    
    public DefaultHttpGet() {
        super();
       this.setHeader("Content-Type", "text/html;charset=utf-8");
    }

    public DefaultHttpGet(final URI uri) {
        super();
        setURI(uri);
        this.setHeader("Content-Type", "text/html;charset=utf-8");
    }

    public DefaultHttpGet(final String uri) {
        super();
        setURI(URI.create(uri));
        this.setHeader("Content-Type", "text/html;charset=utf-8");
    }
    
    public DefaultHttpGet addHeaderValue(String name, String value){
           this.setHeader(name, value);
           return this;
    }
    

}
