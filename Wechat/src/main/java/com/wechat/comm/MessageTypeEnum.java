package com.wechat.comm;


/**
 * 
 * 微信消息 类型
 */
public enum MessageTypeEnum {
    
    TEXT("text","文本消息"),
    IMAGE("image","图片消息"),
    VOICE("voice","音频消息"),
    VIDEO("video","视频消息"),
    SHORTVIDEO("shortvideo","短视频消息"),
    LINK("link","链接消息"),
    LOCATION("location","地址消息"),
    EVENT_SUBSCRIBE("event","subscribe","订阅消息"),
    EVENT_UNSUBSCRIBE("event","unsubscribe","取消订阅消息"),
    EVENT_SCAN("event","SCAN","扫描消息"),
    EVENT_LOCATION("event","LOCATION","定位地理位置消息"),
    EVENT_CLICK("event","CLICK","点击消息"),
    EVNET_VIEW("event","VIEW","查看消息"),
    EVENT_SCANCODE_PUSH("event","scancode_push","扫描码消息"),
    EVENT_PIC_SYSPHOTO("event","pic_sysphoto","拍照消息"),
    EVENT_LOCATION_SELECT("event","location_select","发送位置"),
    EVENT_PIC_PHOTO_OR_ALBUM("event","pic_photo_or_album","相机或本地"),
    EVENT_PIC_WEIXIN("event","pic_weixin","微信相册"),
    EVENT_SCANCODE_WAITMSG("event","scancode_waitmsg","微信相册");
    
    private  MessageTypeEnum(String msgType,String code,String desc){
        this.msgType = msgType;
        this.code = code;
        this.desc = desc;
    }
    private  MessageTypeEnum(String msgType,String desc){
        this.msgType = msgType;
        this.desc = desc;
    }
    
    private String msgType;
    private String code;
    private String desc;
    public String getMsgType() {
        return msgType;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    
    
    public static MessageTypeEnum getMessageByMsgTypeAndCode(String msgType,String code){
               for(MessageTypeEnum msg : MessageTypeEnum.values()){
                     if(code==null){
                         if(msg.getMsgType().equals(msgType)){
                             return msg;
                         } 
                     }else{
                        if(msg.getMsgType().equals(msgType)&&msg.getCode().equals(code)){
                            return msg;
                        }
                     }
               }
               return null;
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
