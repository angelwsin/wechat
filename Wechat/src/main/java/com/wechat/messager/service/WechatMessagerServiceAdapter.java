package com.wechat.messager.service;

import com.wechat.comm.MessageTypeEnum;
import com.wechat.comm.MsgContext;

public interface WechatMessagerServiceAdapter {
    
    
     public String    handleMsg(MsgContext msgContext);
     public MessageTypeEnum  getMsgType();

}
