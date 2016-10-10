package com.wechat.comm;


/**
 * 
 * 微信消息 类型
 */
public enum MessageTypeEnum {
    
    TEXT("text","","文本消息"),
    IMAGE("image","","图片消息"),
    VOICE("voice","","音频消息"),
    VIDEO("video","","视频消息"),
    SHORTVIDEO("shortvideo","","短视频消息"),
    LINK("link","","链接消息"),
    LOCATION("location","","地址消息"),
    EVENT_SUBSCRIBE("event","subscribe","订阅消息"),
    EVENT_UNSUBSCRIBE("event","unsubscribe","取消订阅消息"),
    EVENT_SCAN("event","SCAN","扫描消息"),
    EVENT_LOCATION("event","LOCATION","定位地理位置消息"),
    EVENT_CLICK("evnet","CLICK","点击消息"),
    EVNET_VIEW("evnet","VIEW","查看消息"),
    EVENT_SCANCODE_PUSH("evnet","scancode_push","扫描码消息"),
    EVENT_PIC_SYSPHOTO("evnet","pic_sysphoto","拍照消息");
    
    private  MessageTypeEnum(String eventCode,String code,String desc){
        this.eventCode = eventCode;
        this.code = code;
        this.desc = desc;
    }
    
    private String eventCode;
    private String code;
    private String desc;
    public String getEventCode() {
        return eventCode;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
   
    
    /*text = com.wechat.message.WXTextReqMessage
            image  = com.wechat.message.WXImageReqMessage
            voice = com.wechat.message.WXVoiceReqMessage
            video = com.wechat.message.WXVideoReqMessage
            shortvideo = com.wechat.message.WXVideoReqMessage
            link = com.wechat.message.WXLinkReqMessage
            location = com.wechat.message.WXLocationReqMessage
            event.subscribe = com.wechat.message.WXSubscribeEventMessage
            event.unsubscribe = com.wechat.message.WXUnsubscribeEventMessage
            event.SCAN = com.wechat.message.WX2DScanEventMessage
            event.LOCATION = com.wechat.message.WXLocationEventMessage
            event.CLICK = com.wechat.message.WXClickEventMessage
            event.VIEW = com.wechat.message.WXViewEventMessage
            event.scancode_push = com.wechat.message.WXScanCodePushMessage
            event.pic_sysphoto = com.wechat.message.WXPicSysPhotoMessage*/

}
