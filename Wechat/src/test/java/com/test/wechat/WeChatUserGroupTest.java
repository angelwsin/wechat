package com.test.wechat;

import org.junit.Test;

import com.wechat.comm.WechatLangEnum;
import com.wechat.manager.user.WeChatUserGroupManagerImpl;
import com.wechat.manager.user.WeChatUserManagerImpl;

public class WeChatUserGroupTest {
    
    
    
    
    
    
    
   // @Test
    public void testCreat()throws Exception{
        WeChatUserGroupManagerImpl man  = new WeChatUserGroupManagerImpl();
        man.createGroup("test");
        
    }
   // @Test
    public void testget()throws Exception{
        WeChatUserGroupManagerImpl man  = new WeChatUserGroupManagerImpl();
        System.out.println(man.getGroups().getGroups().get(0).getName());;
    }
    @Test
    public void testUser()throws Exception{
       // oHtBdtxHaMqGvC42WRpe7FeQBOEo
        WeChatUserManagerImpl user = new WeChatUserManagerImpl();
        System.out.println(user.getUserInfoByOpenID("oHtBdtxHaMqGvC42WRpe7FeQBOEo", WechatLangEnum.ZH_CN).getNickname());
        
    }

}
