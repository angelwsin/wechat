package com.wechat.manager;

import com.wechat.menu.WXGetMenu;
import com.wechat.menu.WXTopMenu;

public interface WeChatMenuManager {
    
    
    /**
     * 3x5
     * 
     * @param menu
     * @throws Exception
     */
     public void  create(WXTopMenu menu)throws Exception;
    
     public WXGetMenu  get()throws Exception;
     public void  delete()throws Exception;
}
