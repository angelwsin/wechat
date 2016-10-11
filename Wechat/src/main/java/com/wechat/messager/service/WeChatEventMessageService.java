package com.wechat.messager.service;

import com.wechat.comm.MsgContext;

public interface WeChatEventMessageService {

    public void subscribe(MsgContext msgContext);
    public void unsubscribe(MsgContext msgContext);
    public void scan(MsgContext msgContext);
    public void location(MsgContext msgContext);
    public void click(MsgContext msgContext);
    public void view(MsgContext msgContext);
    public void scanCodePush(MsgContext msgContext);
    public void picSysPhoto(MsgContext msgContext);
}
