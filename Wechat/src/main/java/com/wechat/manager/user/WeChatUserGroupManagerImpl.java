package com.wechat.manager.user;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wechat.DefaultHttpGet;
import com.wechat.DefaultHttpPost;
import com.wechat.WeChatTemplate;
import com.wechat.err.Message.ErrorMessage;
import com.wechat.manager.TokenServiceManager;
import com.wechat.user.WXGetGroups;
import com.wechat.user.WXGroup;
import com.wechat.user.WXUserGroup;
import com.wechat.util.JSONUtil;

public class WeChatUserGroupManagerImpl implements WeChatUserGroupManager{
    private static final Logger LOGGER = LogManager.getLogger(WeChatUserGroupManagerImpl.class);
    private String  createUrl="https://api.weixin.qq.com/cgi-bin/groups/create";
    private String  getUrl ="https://api.weixin.qq.com/cgi-bin/groups/get";
    private String  deleteUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete";

    public void createGroup(String groupName) throws Exception{
        WeChatTemplate we = new WeChatTemplate();
        WXGroup group = new WXGroup();
        group.setName(groupName);
        WXUserGroup userGroup = new WXUserGroup();
        userGroup.setGroup(group);
        DefaultHttpPost post = new DefaultHttpPost(createUrl+"?access_token="+TokenServiceManager.acessToken());
        post.addHeaderValue("Content-Type", "application/json;charset=utf-8")
        .addHeaderValue("Accept", "application/json").buildStringContent(JSONUtil.encode(userGroup));;
        try {
           String resp =  we.doForString(post);
           LOGGER.info(resp);
            ErrorMessage errMsg = JSONUtil.getJsonT(resp, ErrorMessage.class);
            if(errMsg.getErrcode()>0){
                throw new Exception(errMsg.getErrmsg());  
            }
          
        } catch (ClientProtocolException e) {
            LOGGER.error(" 创建分组异常", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }

    public WXGetGroups getGroups() throws Exception {
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
           WXGetGroups groups = JSONUtil.getJsonT(resp, WXGetGroups.class);
            return groups;
          
        } catch (ClientProtocolException e) {
            
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
        return null;
    }

}
