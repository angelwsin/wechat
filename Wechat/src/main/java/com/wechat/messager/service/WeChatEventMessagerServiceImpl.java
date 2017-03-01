package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.event.WX2DCodeScanEventMessage;
import com.wechat.message.event.WXClickEventMessage;
import com.wechat.message.event.WXLocationEventMessage;
import com.wechat.message.event.WXLocationSelectMessage;
import com.wechat.message.event.WXPicSysPhotoMessage;
import com.wechat.message.event.WXScanCodePushMessage;
import com.wechat.message.event.WXSubscribeEventMessage;
import com.wechat.message.event.WXUnsubscribeEventMessage;
import com.wechat.message.event.WXViewEventMessage;

@Service("wechatEventService")
public class WeChatEventMessagerServiceImpl implements WeChatMessagerService,WeChatEventMessageService{

    private static final Logger LOGGER = LogManager.getLogger(WeChatEventMessagerServiceImpl.class);
    
    
    

    public String execute(MsgContext msgContext) {
        return null;
    }

   /* event.subscribe = com.weixin.message.bean.WXSubscribeEventMessage
            event.unsubscribe = com.weixin.message.bean.WXUnsubscribeEventMessage
            event.SCAN = com.weixin.message.bean.WX2DScanEventMessage
            event.LOCATION = com.weixin.message.bean.WXLocationEventMessage
            event.CLICK = com.weixin.message.bean.WXClickEventMessage
            event.VIEW = com.weixin.message.bean.WXViewEventMessage
            event.scancode_push = com.weixin.message.bean.WXScanCodePushMessage
            event.pic_sysphoto = com.weixin.message.bean.WXPicSysPhotoMessage
*/
    @WeChatMsg(clazz=WXSubscribeEventMessage.class,code="subscribe")
    public String subscribe(MsgContext msgContext) {
        WXSubscribeEventMessage msg = (WXSubscribeEventMessage) msgContext.getMsg();
        return null;
          
    }



    @WeChatMsg(clazz=WXUnsubscribeEventMessage.class,code="unsubscribe")
    public String unsubscribe(MsgContext msgContext) {
        WXUnsubscribeEventMessage msg = (WXUnsubscribeEventMessage) msgContext.getMsg();
        return null;
    }



    @WeChatMsg(clazz=WX2DCodeScanEventMessage.class,code="SCAN")
    public String scan(MsgContext msgContext) {
        WX2DCodeScanEventMessage msg = (WX2DCodeScanEventMessage) msgContext.getMsg();
        return null;
    }



    @WeChatMsg(clazz=WXLocationEventMessage.class,code="LOCATION")
    public String location(MsgContext msgContext) {
        WXLocationEventMessage msg = (WXLocationEventMessage) msgContext.getMsg();
        return null;
    }



    @WeChatMsg(clazz=WXClickEventMessage.class,code="CLICK")
    public String click(MsgContext msgContext) {
        WXClickEventMessage  msg = (WXClickEventMessage) msgContext.getMsg();
        LOGGER.info(" WXClickEventMessage "+msg.getEventKey());
        return null;
    }



    @WeChatMsg(clazz=WXViewEventMessage.class,code="VIEW")
    public String view(MsgContext msgContext) {
        WXViewEventMessage msg = (WXViewEventMessage) msgContext.getMsg();
        return null;
    }



    @WeChatMsg(clazz=WXScanCodePushMessage.class,code="scancode_push")
    public String scanCodePush(MsgContext msgContext) {
        WXScanCodePushMessage  msg = (WXScanCodePushMessage) msgContext.getMsg();
        return null;
    }



    @WeChatMsg(clazz=WXPicSysPhotoMessage.class,code="pic_sysphoto")
    public String picSysPhoto(MsgContext msgContext) {
        WXPicSysPhotoMessage  msg = (WXPicSysPhotoMessage) msgContext.getMsg();
        return null;
    }

    @WeChatMsg(clazz=WXLocationSelectMessage.class,code="location_select")
    public String locationSelect(MsgContext msgContext) {
        return null;
    }

    @WeChatMsg(clazz=WXPicSysPhotoMessage.class,code="pic_photo_or_album")
    public String picPhotoOrAlbum(MsgContext msgContext) {
        return null;
    }

    @WeChatMsg(clazz=WXPicSysPhotoMessage.class,code="pic_weixin")
    public String picWeixin(MsgContext msgContext) {
        return null;
    }

    @WeChatMsg(clazz=WXScanCodePushMessage.class,code="scancode_waitmsg")
    public String scanCodeWaitMsg(MsgContext msgContext) {
        return null;
    }
    
 
     
    
}
