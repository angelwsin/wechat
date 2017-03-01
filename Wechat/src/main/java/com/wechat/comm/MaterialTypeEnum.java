package com.wechat.comm;

public enum MaterialTypeEnum {
    
    图片("image"),
    语音("voice"),
    视频("video"),
    缩略图("thumb");
    
    
    private String code;
    MaterialTypeEnum(String code){
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    
    
    
    
    

}
