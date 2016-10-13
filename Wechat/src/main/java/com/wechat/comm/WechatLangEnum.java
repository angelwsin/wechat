package com.wechat.comm;

public enum WechatLangEnum {
    
    ZH_CN("zh_CN","中文简体"),
    ZH_TW("zh_TW","中文繁体"),
    EN("en","英语");
    
    private WechatLangEnum(String code,String desc){
             this.code = code;
             this.desc = desc;
    }
    
    private String code;
    private String desc;
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    
    

}
