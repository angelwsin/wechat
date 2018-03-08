package com.wechat.messager.service;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MessageTypeEnum;
import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.manager.user.WeChatUserManager;
import com.wechat.message.WXTextReqMessage;
import com.wechat.message.WXTextRespMessage;
import com.wechat.ws.ConnectUtils;

@Service("wechatTextService")
public class WeChatTextMessagerServiceImpl implements WeChatMessagerService{
	
	@Resource(name="weChatUserManager")
	private WeChatUserManager      weChatUserManager;
	@Resource(name="wechatEmotionProp")
	private Properties             wechatEmotionProp;
	
	Pattern pattern = Pattern.compile("<img.*src=\"(.*)\".*alt.*>");
	
	

    

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
        	String tx = wechatEmotionProp.getProperty(msg.getContent());
        	if(tx!=null){
        		Matcher matcher = pattern.matcher(tx);
            	if(matcher.find()){
            		tx = matcher.group(1);
            	}	
        	}
        	
        	//WXUserInfo userInfo = weChatUserManager.getUserInfoByOpenID(msg.getFromUserName(), WechatLangEnum.ZH_CN);
        	ConnectUtils.sendText(ConnectUtils.View, tx==null?msg.getContent():"img:"+tx);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //WXMessageFactory.getMessageToXmlDefault(message)
        return "";
       
    }

     
    
}
