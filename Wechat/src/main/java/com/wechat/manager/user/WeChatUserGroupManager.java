package com.wechat.manager.user;

import com.wechat.user.WXGetGroups;

public interface WeChatUserGroupManager {
    
    public void createGroup(String groupName)throws Exception;
    public WXGetGroups getGroups()throws Exception;

}
