package com.wechat.manager;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wechat.DefaultHttpGet;
import com.wechat.DefaultHttpPost;
import com.wechat.WeChatTemplate;
import com.wechat.comm.Const;
import com.wechat.err.Message.ErrorMessage;
import com.wechat.menu.WXGetMenu;
import com.wechat.menu.WXTopMenu;
import com.wechat.util.JSONUtil;

public class WeChatMenuManagerImpl implements WeChatMenuManager{
    private static final Logger LOGGER = LogManager.getLogger(WeChatMenuManagerImpl.class);
          private String  createUrl="https://api.weixin.qq.com/cgi-bin/menu/create";
          private String  getUrl ="https://api.weixin.qq.com/cgi-bin/menu/get";
          private String  deleteUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete";
    

          
    public void create(WXTopMenu menu) throws Exception {
        WeChatTemplate we = new WeChatTemplate();
        DefaultHttpPost post = new DefaultHttpPost(createUrl+"?access_token="+TokenServiceManager.acessToken());
        post.addHeaderValue("Content-Type", "application/json;charset=utf-8")
        .addHeaderValue("Accept", "application/json").buildStringContent(JSONUtil.encode(menu));;
        try {
           String resp =  we.doForString(post);
           LOGGER.info(resp);
            ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
            if(Const.ERRCODE!=errMsg.getErrcode()){
                throw new Exception(errMsg.getErrmsg());
            }
          
        } catch (ClientProtocolException e) {
            LOGGER.error(" 创建菜单异常", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }



    public WXGetMenu get() throws Exception {
        WeChatTemplate we = new WeChatTemplate();
        DefaultHttpGet get = new DefaultHttpGet(getUrl+"?access_token="+TokenServiceManager.acessToken());
        get.addHeaderValue("Accept", "application/json");
        try {
           String resp =  we.doForString(get);
           LOGGER.info(resp);
           ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
           if(errMsg.getErrcode()>0){
               throw new Exception(errMsg.getErrmsg());  
           }
           WXGetMenu menu = JSONUtil.getJsonT(resp, WXGetMenu.class);
            return menu;
          
        } catch (ClientProtocolException e) {
            
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
        return null;
    }



    public void delete() throws Exception {
        WeChatTemplate we = new WeChatTemplate();
        DefaultHttpGet get = new DefaultHttpGet(deleteUrl+"?access_token="+TokenServiceManager.acessToken());
        get.addHeaderValue("Accept", "application/json");
        try {
           String resp =  we.doForString(get);
           LOGGER.info(resp);
           ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
           if(Const.ERRCODE!=errMsg.getErrcode()){
               throw new Exception(errMsg.getErrmsg());
           }
           
        } catch (ClientProtocolException e) {
            
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }
    
    

}
