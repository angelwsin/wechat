package com.wechat.biz.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wechat.comm.MessageTypeEnum;
import com.wechat.comm.MsgContext;
import com.wechat.messager.service.WechatMessagerServiceAdapter;

@Service("unsubscribeEventService")
public class UnsubscribeEventService implements WechatMessagerServiceAdapter{

    private static final Logger LOGGER = LogManager.getLogger(UnsubscribeEventService.class);
    public String handleMsg(MsgContext msgContext) {
        LOGGER.info(" 取消关注 ");
        return null;
    }

    public MessageTypeEnum getMsgType() {
        return MessageTypeEnum.EVENT_UNSUBSCRIBE;
    }

}
