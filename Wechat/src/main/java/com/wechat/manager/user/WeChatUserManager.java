package com.wechat.manager.user;

import java.util.List;

import com.wechat.comm.WechatLangEnum;
import com.wechat.user.WXOpenIdLang;
import com.wechat.user.WXUserInfo;
import com.wechat.user.WXUserInfos;

public interface WeChatUserManager {
    
    
    public WXUserInfo getUserInfoByOpenID(String openid,WechatLangEnum lang)throws Exception;
    
    public WXUserInfos   batchGetUserInfo(List<WXOpenIdLang> openIdLangs)throws Exception;

    
}
