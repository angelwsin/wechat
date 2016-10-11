package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXLocationReqMessage;

@Service("wechatLocationService")
public class WeChatLocationMessagerServiceImpl implements WeChatMessagerService{

    private static final Logger LOGGER = LogManager.getLogger(WeChatLocationMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXLocationReqMessage.class)
    public void execute(MsgContext msgContext) {
        WXLocationReqMessage msg = (WXLocationReqMessage) msgContext.getMsg();
    }

     
    
}
