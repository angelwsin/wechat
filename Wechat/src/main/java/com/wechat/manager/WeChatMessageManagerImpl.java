package com.wechat.manager;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.wechat.comm.Const;
import com.wechat.comm.MessageTypeEnum;
import com.wechat.comm.MsgContext;
import com.wechat.comm.WeChatMsg;
import com.wechat.message.WXMessage;
import com.wechat.util.StringUtils;
import com.wechat.util.WXMessageFactory;

@Service("weChatMessageManager")
public class WeChatMessageManagerImpl implements WeChatMessageManager,ApplicationContextAware{
    
    private static final Logger LOGGER = LogManager.getLogger(WeChatMessageManagerImpl.class);
      private ApplicationContext  applicationContext;

    public void execute(MsgContext msgContext) throws Exception{
       // LOGGER.info(" msg Context :"+JSONUtil.encode(msgContext));
        MessageTypeEnum  msgType =  msgContext.getMsgTypeEnum();
        if(null==msgType){
            throw new Exception("msgContext 不能为空！");
        }
        Object  wechatMsgService =  applicationContext.getBean(wrapBeanName(msgType.getMsgType()));
        Method[]  methods = wechatMsgService.getClass().getDeclaredMethods();
        Method   exeMethode = null;
        Method   defaultMethod = null;
        for(Method method : methods){
            WeChatMsg wechatMsg =  method.getAnnotation(WeChatMsg.class);
            if(null==wechatMsg){
                continue;
            }
            if(wechatMsg.code().equals(msgType.getCode())){
                exeMethode = method;
                break;
            }
            if(Const.EXECUTE.equals(method.getName())){
                defaultMethod = method;
            }
        }
        if(null==exeMethode && defaultMethod!=null){
            exeMethode = defaultMethod;
        }
        WeChatMsg wechatMsg =  exeMethode.getAnnotation(WeChatMsg.class);
        XStream s = new XStream();
        Document docu = msgContext.getDocument();
        WXMessageFactory.listFields(wechatMsg.clazz(),s);
        Element e =  docu.getRootElement();
        e.setName(wechatMsg.clazz().getName());
        WXMessage msg = (WXMessage) s.fromXML(e.asXML());
        msgContext.setMsg(msg);
        exeMethode.invoke(wechatMsgService, msgContext);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
    }
    
    
   
    
    private String   wrapBeanName(String msgType){
        
              return  "wechat"+StringUtils.firstToUpperCase(msgType)+"Service";
    }
      
    
    
       

}