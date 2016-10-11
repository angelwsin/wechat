package com.wechat.dispatcher;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.comm.MsgContext;
import com.wechat.manager.WeChatMessageManager;
import com.wechat.util.StringUtils;
import com.wechat.util.WXMessageFactory;


@Controller
public class WeChatDispatcherController extends BaseController{
	
	private static final Logger LOGGER = LogManager.getLogger(WeChatDispatcherController.class);
	
	@Resource(name="weChatMessageManager")
	private WeChatMessageManager weChatMessageManager;
	
	         @RequestMapping(value="/weChatDispatcher")
	         public String  wxSignature(HttpServletRequest request,HttpServletResponse response){
	        	// TODO Auto-generated method stub
	             LOGGER.info("wxSignature ");
	        	 if(!isPost(request)){
	        		 doGet(request, response);
	        	 }else{
	        		  doPost(request, response);
	        	 }
	        	   return null;
	         }
	         /*
	          * 微信接口接入验证
	          */
	       private void doGet(HttpServletRequest request,HttpServletResponse response){
	    	   String signature = request.getParameter("signature");
	  	       String timestamp = request.getParameter("timestamp");
	  	       String nonce = request.getParameter("nonce");
	  	       String echostr = request.getParameter("echostr");
	  	     LOGGER.info(signature);
	  	     LOGGER.info(timestamp);
	  	     LOGGER.info(nonce);
	  	     LOGGER.info(echostr);
	  	       if(StringUtils.wxCheckSignature(signature, timestamp, nonce, StringUtils.Token)){
	  	    	 writeToResponse(response, echostr);
	  	       }
	       }
	       /*
	        * 微信接口的入口
	        */
	       private void doPost(HttpServletRequest request,HttpServletResponse response){
	           try {
	             MsgContext msgContext = WXMessageFactory.getMessageContext(request.getInputStream());
	             weChatMessageManager.execute(msgContext);
            } catch (IOException e) {
                LOGGER.error("", e);
            } catch (Exception e) {
                LOGGER.error("", e);
            }
	          // handler.handleResponse(response);
	    	/*     
	    	   try {
			 WXMessage msg = 	WXMessageFactory.getMessageInstance(request.getInputStream());
			 msg.setResponse(response);
			 wxMessageService.onMessage(msg);
			 //根据不同的消息分发器
			 //第一种策略 分配给不同handle处理   不同的handle处理 不同的response 不同的handle处理有不同的拦截器
			 //第二种策略  发布订阅机制
			 //第三种策略  事件驱动
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

	       }

	    	
	  
}
