package com.wechat.messager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MessageTypeEnum;
import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXTextReqMessage;
import com.wechat.message.WXTextRespMessage;
import com.wechat.util.WXMessageFactory;

@Service("wechatTextService")
public class WeChatTextMessagerServiceImpl implements WeChatMessagerService{
    

    private static final Logger LOGGER = LogManager.getLogger(WeChatTextMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXTextReqMessage.class)
    public String execute(MsgContext msgContext) {
        WXTextReqMessage msg = (WXTextReqMessage) msgContext.getMsg();
        LOGGER.info(" msg content "+msg.getContent());
        
        WXTextRespMessage message= new WXTextRespMessage();
        message.setCreateTime(System.currentTimeMillis());
        message.setContent("你好");
        message.setMsgType(MessageTypeEnum.TEXT.getMsgType());
        message.setFromUserName(msg.getToUserName());
        message.setToUserName(msg.getFromUserName());
        
        return WXMessageFactory.getMessageToXmlDefault(message);
       
    }

     
    
}
