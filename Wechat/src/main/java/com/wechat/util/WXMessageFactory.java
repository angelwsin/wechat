package com.wechat.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.wechat.comm.MessageTypeEnum;
import com.wechat.comm.MsgContext;
import com.wechat.message.WXNewItmesMessage;
import com.wechat.message.WXNewsRespMessage;

public class WXMessageFactory {
	         public static final String XMLHEADER="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	       
	         private static final Logger LOGGER = LogManager.getLogger(WXMessageFactory.class);
	public static MsgContext getMessageContext(InputStream is) {
	    MsgContext msgContext = new  MsgContext();
		SAXReader reader = new SAXReader();
		StringBuffer buffer = null;
		try {
			
			buffer = new StringBuffer(XMLHEADER);
			String wechatMsg = IOUtils.toString(is);
			LOGGER.info(" wechat msg :"+ wechatMsg);
			buffer.append(wechatMsg);
			Document doc = reader.read(new ByteArrayInputStream(buffer.toString().getBytes()));
			String type = doc.selectSingleNode("/xml/MsgType").getText();
			Node node =  doc.selectSingleNode("/xml/Event");
			String event =node==null?null:node.getText();
			msgContext.setDocument(doc);
			msgContext.setMsgTypeEnum(MessageTypeEnum.getMessageByMsgTypeAndCode(type, event));
			msgContext.setMsgType(type);
			msgContext.setEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		    try {
                is.close();
            } catch (IOException e) {
               // logger.error("", e);
            }
		}

		return msgContext;

	}
	
	public static <T>String getMessageToXml(T message,String[] alias, Class<?>[] clazz){
		     if(alias.length!=clazz.length){
		    	 throw new IllegalArgumentException("非法的参数");
		     }
		XStream s = new XStream();
		for(int i=0;i<alias.length;i++){
			s.alias(alias[i], clazz[i]);
		}
		return s.toXML(message);
	}
	public static <T>String getMessageToXml(T message, Class<?>[] clazz){
	   
	XStream s = new XStream();
	for(int i=0;i<clazz.length;i++){
		s.processAnnotations(clazz[i]);
	}
	return s.toXML(message);
}
	
	public static <T>String getMessageToXmlDefault(T message){
		     return getMessageToXml(message,new String[]{"xml"},new Class<?>[]{message.getClass()});
	}
	
	public static String getgetMessageToXmlWXNews(WXNewsRespMessage message){
		return getMessageToXml(message,new String[]{"xml","item"} ,new Class<?>[]{WXNewsRespMessage.class,WXNewItmesMessage.class});
	}
	
	public  static void listFields(Class<?> clazz,XStream s){
		  Field[] fields = clazz.getDeclaredFields();
		    if(fields.length==0){
		    	  return ;
		    }
		     for(int i=0;i<fields.length;i++){
		    	 if(fields[i].getType()==List.class){
		    		 ParameterizedType pt = (ParameterizedType) fields[i].getGenericType() ;
		    		 Class<?> clz = (Class<?>) pt.getActualTypeArguments()[0];
		    		 s.processAnnotations(clz);
		    	 }
		    	 listFields(fields[i].getType(),s);
		     }
		 
	}

	        

}
