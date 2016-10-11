package com.wechat.manager;

import com.wechat.comm.MsgContext;

public interface WeChatMessageManager {
    
    
    
     public void  execute(MsgContext msgContext)throws Exception;
    

}
