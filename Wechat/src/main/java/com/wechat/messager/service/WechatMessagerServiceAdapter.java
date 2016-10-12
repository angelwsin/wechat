package com.wechat.messager.service;

import com.wechat.comm.MsgContext;

public interface WechatMessagerServiceAdapter {
    
    
     public String    handleMsg(MsgContext msgContext);

}
