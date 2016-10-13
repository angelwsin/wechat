package com.wechat.manager.user;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wechat.DefaultHttpGet;
import com.wechat.DefaultHttpPost;
import com.wechat.WeChatTemplate;
import com.wechat.comm.WechatLangEnum;
import com.wechat.err.Message.ErrorMessage;
import com.wechat.manager.TokenServiceManager;
import com.wechat.user.WXOpeanIdLangs;
import com.wechat.user.WXOpenIdLang;
import com.wechat.user.WXUserInfo;
import com.wechat.user.WXUserInfos;
import com.wechat.util.JSONUtil;

public class WeChatUserManagerImpl implements WeChatUserManager{

    private static final Logger LOGGER = LogManager.getLogger(WeChatUserGroupManagerImpl.class);
    private String  getUrl="https://api.weixin.qq.com/cgi-bin/user/info";
    private String  getbatchUrl = "https://api.weixin.qq.com/cgi-bin/user/info/batchget";
    public WXUserInfo getUserInfoByOpenID(String openid, WechatLangEnum lang)throws Exception {
        WeChatTemplate we = new WeChatTemplate();
        DefaultHttpGet get = new DefaultHttpGet(getUrl+"?access_token="+TokenServiceManager.acessToken()
            +"&openid="+openid+"&lang="+lang.getCode());
        get.addHeaderValue("Accept", "application/json");
        try {
           String resp =  we.doForString(get);
           LOGGER.info(resp);
           ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
           if(errMsg.getErrcode()>0){
               throw new Exception(errMsg.getErrmsg());  
           }
           WXUserInfo userInfo = JSONUtil.getJsonT(resp, WXUserInfo.class);
            return userInfo;
          
        } catch (ClientProtocolException e) {
            
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
        return null;
    }
    public WXUserInfos batchGetUserInfo(List<WXOpenIdLang> openIdLangs) throws Exception {
        WeChatTemplate we = new WeChatTemplate();
        WXOpeanIdLangs  langs = new WXOpeanIdLangs();
        langs.setUser_list(openIdLangs);
        DefaultHttpPost post = new DefaultHttpPost(getbatchUrl+"?access_token="+TokenServiceManager.acessToken());
        post.addHeaderValue("Content-Type", "application/json;charset=utf-8")
        .addHeaderValue("Accept", "application/json").buildStringContent(JSONUtil.encode(langs));;
        try {
           String resp =  we.doForString(post);
           LOGGER.info(resp);
            ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
            if(errMsg.getErrcode()>0){
                throw new Exception(errMsg.getErrmsg());  
            }
            WXUserInfos userInfos = JSONUtil.getJsonT(resp, WXUserInfos.class);
            return userInfos;
        } catch (ClientProtocolException e) {
            LOGGER.error(" 创建分组异常", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
        return null;
    }
}
