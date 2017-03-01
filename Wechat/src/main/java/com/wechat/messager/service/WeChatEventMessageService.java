package com.wechat.messager.service;

import com.wechat.comm.MsgContext;

public interface WeChatEventMessageService {

    public String subscribe(MsgContext msgContext);
    public String unsubscribe(MsgContext msgContext);
    public String scan(MsgContext msgContext);
    public String location(MsgContext msgContext);
    public String click(MsgContext msgContext);
    public String view(MsgContext msgContext);
    public String scanCodePush(MsgContext msgContext);
    public String picSysPhoto(MsgContext msgContext);
    public String locationSelect(MsgContext msgContext);
    public String picPhotoOrAlbum(MsgContext msgContext);
    public String picWeixin(MsgContext msgContext);
    public String scanCodeWaitMsg(MsgContext msgContext);
}
