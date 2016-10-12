package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXTextReqMessage;

@Service("wechatTextService")
public class WeChatTextMessagerServiceImpl implements WeChatMessagerService{
    

    private static final Logger LOGGER = LogManager.getLogger(WeChatTextMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXTextReqMessage.class)
    public void execute(MsgContext msgContext) {
        WXTextReqMessage msg = (WXTextReqMessage) msgContext.getMsg();
        LOGGER.info(" msg content "+msg.getContent());
       
    }

     
    
}
