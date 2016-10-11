package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXImageReqMessage;

@Service("wechatImageService")
public class WeChatImageMessagerServiceImpl implements WeChatMessagerService{

    private static final Logger LOGGER = LogManager.getLogger(WeChatImageMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXImageReqMessage.class)
    public void execute(MsgContext msgContext) {
        WXImageReqMessage msg = (WXImageReqMessage) msgContext.getMsg();
        LOGGER.info(" msg content "+msg.getPicUrl());
    }

     
    
}
