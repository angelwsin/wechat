package com.wechat.message;

import java.util.HashMap;
import java.util.Map;

public class WXTemplateMessage {

    private String touser;
    
    private String template_id;
    
    private String url;
    
    private Map<String,WXTemplateMeta> data = new HashMap<String, WXTemplateMeta>();

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, WXTemplateMeta> getData() {
        return data;
    }

    public void setData(Map<String, WXTemplateMeta> data) {
        this.data = data;
    }

    public void addData(String key,String value,String color){
        data.put(key, new WXTemplateMeta(value,color));
    }
    
}
