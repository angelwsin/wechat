package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXLinkReqMessage;

@Service("wechatLinkService")
public class WeChatLinkMessagerServiceImpl implements WeChatMessagerService{

    private static final Logger LOGGER = LogManager.getLogger(WeChatLinkMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXLinkReqMessage.class)
    public String execute(MsgContext msgContext) {
        WXLinkReqMessage msg = (WXLinkReqMessage) msgContext.getMsg();
       // LOGGER.info(" msg content "+msg.getPicUrl());
        return null;
    }

     
    
}
