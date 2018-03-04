package com.wechat.dispatcher;

import java.io.IOException;
import java.net.URI;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wechat.comm.MsgContext;
import com.wechat.manager.WeChatMessageManager;
import com.wechat.util.StringUtils;
import com.wechat.util.WXMessageFactory;
import com.wechat.ws.ConnectUtils;
import com.wechat.ws.ViewClient;


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
	        * 微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次，如果在调试中，发现用户无法收到响应的消息，可以检查是否消息处理超时。

                                 关于重试的消息排重，有msgid的消息推荐使用msgid排重。事件类型消息推荐使用FromUserName + CreateTime 排重。

                                  假如服务器无法保证在五秒内处理并回复，必须直接回复空串（是指回复一个空字符串，而不是一个XML结构体中content字段的内容为空，请切勿误解），微信服务器不会对此作任何处理，并且不会发起重试。
                                  。这种情况下，可以使用客服消息接口进行异步回复。

                             请开发者注意，一旦遇到以下情况，微信都会在公众号会话中，向用户下发系统提示“该公众号暂时无法提供服务，请稍后再试”：
               1、开发者在5秒内未回复任何内容
              2、开发者回复了异常数据，比如JSON数据等

	        * 
	        */
	       private void doPost(HttpServletRequest request,HttpServletResponse response){
	                   /* try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e1) {
                           // logger.error("", e);
                        }*/
	           try {
	        	   view(request);
	             MsgContext msgContext = WXMessageFactory.getMessageContext(request.getInputStream());
	             String resp = weChatMessageManager.execute(msgContext);
	             LOGGER.info(" resp :"+resp);
	             writeToResponse(response, resp);
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
	       
	       
	       public void  view(HttpServletRequest request){
	    	  if(ConnectUtils.getSession(ConnectUtils.View)==null){
	    		//加入websocket 显示
		        	 WebSocketContainer container = (WebSocketContainer) request.getServletContext().getAttribute("javax.websocket.server.ServerContainer");
		        	 try {
		        		 //System.out.println("ws://"+request.getContextPath()+"/ws/chat");
						Session session = container.connectToServer(ViewClient.class,new URI("ws://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ws/chat"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new RuntimeException("view Session失败", e);
					} 
	    	  }
	    	 
	       }

	    	
	  
}
