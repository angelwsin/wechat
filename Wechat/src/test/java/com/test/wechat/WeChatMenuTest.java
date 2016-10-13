package com.test.wechat;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.wechat.WeChatTemplate;
import com.wechat.manager.TokenServiceManager;
import com.wechat.manager.WeChatMenuManagerImpl;
import com.wechat.menu.WXGetMenu;
import com.wechat.menu.WXTopMenu;
import com.wechat.util.JSONUtil;

public class WeChatMenuTest {
    
    
   @Test
    public void addMenuTest()throws Exception{
        String msg =     "{\"button\":[{ \"type\":\"click\", \"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"name\":\"菜单\",\"sub_button\":[{   \"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}";
        
        WeChatMenuManagerImpl chat = new WeChatMenuManagerImpl();
       String content =   IOUtils.toString(new FileInputStream(new File("d:\\menu.json")));
        chat.create(JSONUtil.getJsonT(content, WXTopMenu.class));
       
    }
    //@Test
    public void testGet(){
        WeChatMenuManagerImpl chat = new WeChatMenuManagerImpl();
        try {
            WeChatTemplate we = new WeChatTemplate();
            WXGetMenu menu =   chat.get();
            System.out.println(JSONUtil.encode(menu));
            System.out.println(we.doGetForString("https://api.weixin.qq.com/cgi-bin/menu/get?access_token="+TokenServiceManager.acessToken()));
        } catch (Exception e) {
            e.printStackTrace();
          //  logger.error("", e);
        }
    }

}
