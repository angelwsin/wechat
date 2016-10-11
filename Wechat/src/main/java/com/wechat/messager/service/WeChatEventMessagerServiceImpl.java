package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WX2DCodeScanEventMessage;
import com.wechat.message.WXClickEventMessage;
import com.wechat.message.WXLocationEventMessage;
import com.wechat.message.WXPicSysPhotoMessage;
import com.wechat.message.WXScanCodePushMessage;
import com.wechat.message.WXSubscribeEventMessage;
import com.wechat.message.WXUnsubscribeEventMessage;
import com.wechat.message.WXViewEventMessage;

@Service("wechatEventService")
public class WeChatEventMessagerServiceImpl implements WeChatMessagerService,WeChatEventMessageService{

    private static final Logger LOGGER = LogManager.getLogger(WeChatEventMessagerServiceImpl.class);
    
    
    

    public void execute(MsgContext msgContext) {
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
    public void subscribe(MsgContext msgContext) {
        WXSubscribeEventMessage msg = (WXSubscribeEventMessage) msgContext.getMsg();
    }



    @WeChatMsg(clazz=WXUnsubscribeEventMessage.class,code="unsubscribe")
    public void unsubscribe(MsgContext msgContext) {
        WXUnsubscribeEventMessage msg = (WXUnsubscribeEventMessage) msgContext.getMsg();
    }



    @WeChatMsg(clazz=WX2DCodeScanEventMessage.class,code="SCAN")
    public void scan(MsgContext msgContext) {
        WX2DCodeScanEventMessage msg = (WX2DCodeScanEventMessage) msgContext.getMsg();
    }



    @WeChatMsg(clazz=WXLocationEventMessage.class,code="LOCATION")
    public void location(MsgContext msgContext) {
        WXLocationEventMessage msg = (WXLocationEventMessage) msgContext.getMsg();
    }



    @WeChatMsg(clazz=WXClickEventMessage.class,code="CLICK")
    public void click(MsgContext msgContext) {
        WXClickEventMessage  msg = (WXClickEventMessage) msgContext.getMsg();
        LOGGER.info(" WXClickEventMessage "+msg.getEventKey());
    }



    @WeChatMsg(clazz=WXViewEventMessage.class,code="VIEW")
    public void view(MsgContext msgContext) {
        WXViewEventMessage msg = (WXViewEventMessage) msgContext.getMsg();
    }



    @WeChatMsg(clazz=WXScanCodePushMessage.class,code="scancode_push")
    public void scanCodePush(MsgContext msgContext) {
        WXScanCodePushMessage  msg = (WXScanCodePushMessage) msgContext.getMsg();
    }



    @WeChatMsg(clazz=WXPicSysPhotoMessage.class,code="pic_sysphoto")
    public void picSysPhoto(MsgContext msgContext) {
        WXPicSysPhotoMessage  msg = (WXPicSysPhotoMessage) msgContext.getMsg();
    }
    

     
    
}
