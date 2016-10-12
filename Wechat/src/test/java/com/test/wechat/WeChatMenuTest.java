package com.test.wechat;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.wechat.DefaultHttpPost;
import com.wechat.WeChatTemplate;
import com.wechat.manager.TokenServiceManager;
import com.wechat.menu.WXMenu;
import com.wechat.menu.WXTopMenu;
import com.wechat.util.JSONUtil;

public class WeChatMenuTest {
    
    
    @Test
    public void addMenuTest()throws Exception{
        String msg =     "{\"button\":[{ \"type\":\"click\", \"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"name\":\"菜单\",\"sub_button\":[{   \"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}";
        
        WXTopMenu top = new WXTopMenu();
        
        WXMenu m1 = new WXMenu();
       m1.setName("今日歌曲");
       m1.setKey("V1001_TODAY_MUSIC");
       m1.setType("click");
        WXMenu m2 = new WXMenu();
           m2.setName("菜单");
           List<WXMenu> sub2 = new ArrayList<WXMenu>();
            WXMenu m2s1 = new WXMenu();
            m2s1.setName("搜索");
            m2s1.setType("view");
            m2s1.setUrl("http://www.soso.com/");
            m2s1.setSub_button(new ArrayList<WXMenu>() );
            WXMenu m2s2 = new WXMenu();
            m2s2.setName("视频");
            m2s2.setUrl("http://v.qq.com/");
            m2s2.setType("view");
            m2s2.setSub_button(new ArrayList<WXMenu>() );
            sub2.add(m2s1);
            sub2.add(m2s2);
            m2.setSub_button(sub2);
     List<WXMenu> l = new ArrayList<WXMenu>();
     l.add(m1);
     l.add(m2);
        top.setButton(l);
        WeChatTemplate we = new WeChatTemplate();
        System.out.println(JSONUtil.encode(top));
        DefaultHttpPost post = new DefaultHttpPost("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+TokenServiceManager.acessToken());
        post.addHeaderValue("Content-Type", "application/json;charset=utf-8").addHeaderValue("Accept", "application/json").buildStringContent("body="+ JSONUtil.encode(top)+"&access_token="+TokenServiceManager.getAcessToken());;
        try {
           System.out.println(we.doForString(post));
        } catch (ClientProtocolException e) {
           // logger.error("", e);
        } catch (IOException e) {
           //.error("", e);
        }
       
    }

}
