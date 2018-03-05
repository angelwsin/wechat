package com.wechat.messager.service;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MessageTypeEnum;
import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.comm.WechatLangEnum;
import com.wechat.manager.user.WeChatUserManager;
import com.wechat.message.WXTextReqMessage;
import com.wechat.message.WXTextRespMessage;
import com.wechat.user.WXUserInfo;
import com.wechat.util.WXMessageFactory;
import com.wechat.ws.ConnectUtils;

@Service("wechatTextService")
public class WeChatTextMessagerServiceImpl implements WeChatMessagerService{
	
	@Resource(name="weChatUserManager")
	private WeChatUserManager      weChatUserManager;
    

    private static final Logger LOGGER = LogManager.getLogger(WeChatTextMessagerServiceImpl.class);
    @WeChatMsg(clazz=WXTextReqMessage.class)
    public String execute(MsgContext msgContext) {
        WXTextReqMessage msg = (WXTextReqMessage) msgContext.getMsg();
        LOGGER.info(" msg content "+msg.getContent());
        
        WXTextRespMessage message= new WXTextRespMessage();
        message.setCreateTime(System.currentTimeMillis());
        message.setContent("你好");
        message.setMsgType(MessageTypeEnum.TEXT.getMsgType());
        message.setFromUserName(msg.getToUserName());
        message.setToUserName(msg.getFromUserName());
        try {
        	WXUserInfo userInfo = weChatUserManager.getUserInfoByOpenID(msg.getFromUserName(), WechatLangEnum.ZH_CN);
        	ConnectUtils.sendText(ConnectUtils.View, userInfo.getNickname()+":"+msg.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return WXMessageFactory.getMessageToXmlDefault(message);
       
    }

     
    
}
