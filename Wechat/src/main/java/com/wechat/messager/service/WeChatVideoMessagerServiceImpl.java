package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXVideoReqMessage;

@Service("wechatVideoService")
public class WeChatVideoMessagerServiceImpl implements WeChatMessagerService{

    private static final Logger LOGGER = LogManager.getLogger(WeChatVideoMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXVideoReqMessage.class)
    public String execute(MsgContext msgContext) {
        WXVideoReqMessage msg = (WXVideoReqMessage) msgContext.getMsg();
       // LOGGER.info(" msg content "+msg.getPicUrl());
        return null;
    }

     
    
}
