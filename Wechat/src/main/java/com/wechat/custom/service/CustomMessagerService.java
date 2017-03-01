package com.wechat.custom.service;

import com.wechat.message.WXCustBaseRespMessage;

public interface CustomMessagerService {
    
    
    public void sendMsg(WXCustBaseRespMessage msg)throws Exception;

}
