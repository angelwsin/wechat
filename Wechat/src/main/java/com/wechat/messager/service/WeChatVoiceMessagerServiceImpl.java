package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXVoiceReqMessage;

@Service("wechatVoiceService")
public class WeChatVoiceMessagerServiceImpl implements WeChatMessagerService{

    private static final Logger LOGGER = LogManager.getLogger(WeChatVoiceMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXVoiceReqMessage.class)
    public void execute(MsgContext msgContext) {
        WXVoiceReqMessage msg = (WXVoiceReqMessage) msgContext.getMsg();
       // LOGGER.info(" msg content "+msg.getPicUrl());
    }

     
    
}
