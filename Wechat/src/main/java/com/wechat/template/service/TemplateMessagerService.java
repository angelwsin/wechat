package com.wechat.template.service;

import com.wechat.message.WXTemplateMessage;

public interface TemplateMessagerService {
    
    public void      sendTemplateMsg(WXTemplateMessage msg)throws Exception;

}
