package com.wechat.biz.service.impl;

import org.springframework.stereotype.Service;

import com.wechat.comm.MsgContext;
import com.wechat.messager.service.WechatMessagerServiceAdapter;


@Service("userService")
public class UserService implements WechatMessagerServiceAdapter{

    public String handleMsg(MsgContext msgContext) {
        return null;
    }
    
    
    
    
    
    

}
