package com.wechat.manager;

import java.util.List;

import com.wechat.messager.service.WeChatMessagerService;

public class WeChatMessageManagerImpl implements WeChatMessageManager{
    
    
       private List<WeChatMessagerService>  messagerServiceList ;

    public void setMessagerServiceList(List<WeChatMessagerService> messagerServiceList) {
        this.messagerServiceList = messagerServiceList;
    }
       
       

}
