package com.wechat.message;

public class WXTemplateMeta {
    
    private String value;
    
    private String color;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public WXTemplateMeta(String value,String color){
             this.value = value;
             this.color = color;
    }
    

}
